package cn.awall.awalladmin.controller;

import cn.awall.awalladmin.dao.UserMapper;
import cn.awall.awalladmin.pojo.User;
import cn.awall.awalladmin.service.impl.UserServiceImpl;
import cn.awall.awalladmin.utils.*;
import cn.awall.awalladmin.vo.CommonResult;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TxSmsTemplate txSmsTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private ObjectMapper mapper;

    @Resource
    UserToObjectNodeUtils userToObjectNodeUtils;

    @Autowired
    private UserMapper userMapper;
    private String yzm_reg = "_yzm_reg";
    private String yzm_reset = "_yzm_reset";

    /**
     * 注册时：手机号校验，判断手机号是否存在
     *
     * @param data
     * @return 账号是否允许注册
     * @throws JsonProcessingException
     */
    @PostMapping("/tel")
    public String isUser(@RequestBody Object data) throws JsonProcessingException {

        Map<String, String> map = new ObjectMapper().readValue(JSON.toJSONString(data), Map.class);
        String tel = map.get("tel");
        if (!MobileUtils.isMobileNO(tel)) {
            return "手机号格式不正确！";
        }

        System.out.println("tel = " + tel);
        boolean user = userService.isUser(tel);
        System.out.println("user = " + user);
        if (user) {
            return "OK!";
        } else {
            return "账号已存在！";
        }
    }

    /**
     * 注册账号时发送短信
     *
     * @param tel
     * @param session
     * @return 短信发送情况
     */
    @RequestMapping("/sms")
    public String sms(String tel, HttpSession session) {

        //检查无效手机号，减轻数据库负担，和验证码安全！
        if (!MobileUtils.isMobileNO(tel)) {
            return "手机号格式不正确！无法发送验证码！";
        }

        //检测账号是否存在，防止前台没有阻止用户使用已注册的手机号获取注册验证码！
        if (!userService.isUser(tel)) {
            return "账号已存在，不允许发送验证码!";
        }

        //生成六位数字随机验证码！
        String yzm = Integer.toString(100000 + (int) (Math.random() * ((999999 - 100000) + 1)));

        System.out.println("yzm = " + yzm);
        System.out.println("sms" + tel);

        //发送短信！
        String Msg = txSmsTemplate.sendMesModel(tel, yzm);
        System.out.println(Msg);

        //将手机号和验证码放到Redis中
        redisUtils.set(tel + yzm_reg, yzm, 300L);
        return "短信发送成功";
    }

    /**
     * 接受注册的数据
     *
     * @param token
     * @return 注册成功与否
     * @throws JsonProcessingException
     */
    @PostMapping("/register")
    public String register(@RequestBody Object token) throws JsonProcessingException {
        System.out.println("用户注册");
        Map<String, String> map = new ObjectMapper().readValue(JSON.toJSONString(token), Map.class);
        //检测手机验证码是否正确
        if (!map.get("code").equals(redisUtils.get(map.get("tel") + yzm_reg))) {
            return "验证码错误！";
        }
        //封装成user
        User user = new User();
        user.setTel(map.get("tel"));
        user.setPassword(map.get("password"));
        user.setNikename(map.get("nikename"));
        System.out.println("register controller:" + user);
        //用户注册
        boolean register = userService.register(user);
        if (register) {
            return "注册成功！";
        } else {
            return "注册失败！";
        }

    }

    /**
     * 用户登录
     *
     * @param response
     * @param object
     * @param request
     * @return 登录是否成功
     * @throws JsonProcessingException
     */
    @PostMapping("/login")
    public CommonResult<String> login(HttpServletResponse response, @RequestBody Object object, HttpServletRequest request) throws JsonProcessingException {

        //打印前端传来的对象
        System.out.println("Object:" + JSON.toJSONString(object));

        System.out.println("verifyCode" + request.getSession().getAttribute("verifyCode"));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(JSON.toJSONString(object), Map.class);
        System.out.println(map.get("tel"));
        System.out.println(map.get("password"));
        System.out.println(map.get("code"));
        User user = new User();
        String tel = map.get("tel");
        String password = map.get("password");

        user.setTel(tel);
        user.setPassword(password);

        if (!request.getSession().getAttribute("verifyCode").equals(map.get("code"))) {
            return new CommonResult<>(500, "验证码错误");
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(user.getTel(), user.getPassword()));
            // 将当前会话的手机号存一波

            request.getSession().setAttribute("userId", String.valueOf(userMapper.findUserByTel(user.getTel()).getUserId()));
            return new CommonResult<>(200, "登录成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new CommonResult<>(500, "用户名或密码错误");
        }

    }

    /**
     * 获取图片验证码
     *
     * @param response
     * @param request
     */
    @RequestMapping("/getVerifyCode")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {

        try {
            int width = 200;
            int height = 69;

            BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            //生成对应宽高的初始图片
            String randomText = VerifyCode.drawRandomText(width, height, verifyImg);

            //单独的一个类方法，出于代码复用考虑，进行了封装。
            //功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符

            request.getSession().setAttribute("verifyCode", randomText);
            System.out.println("randomText = " + randomText);

            response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别

            OutputStream os = response.getOutputStream(); //获取文件输出流

            ImageIO.write(verifyImg, "png", os);//输出图片流

            os.flush();

            os.close();//关闭流

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    /**
     * 重置密码时手机号校验
     *
     * @param tel
     * @return 是否可以重置密码
     */
    @PostMapping("/resettel")
    public String resetisUser(String tel) {

        if (!MobileUtils.isMobileNO(tel)) return "手机号格式不正确！";

        System.out.println("tel = " + tel);
        boolean user = userService.isUser(tel);
        System.out.println("user = " + user);
        if (user) return "该账号未注册！";
        else return "OK！";
    }

    /**
     * 重置密码时发送手机验证码
     *
     * @param tel
     * @return 短信发送情况
     */
    @RequestMapping("/resetsms")
    public String resetsms(String tel) {

        //检查无效手机号，减轻数据库负担，和验证码安全！
        if (!MobileUtils.isMobileNO(tel)) {
            return "手机号格式不正确！无法发送验证码！";
        }

        //检测账号是否存在，防止前台没有阻止用户使用未注册的手机号获取获取验证码！
        if (userService.isUser(tel)) {
            return "账号不存在，不允许发送验证码!";
        }

        //生成六位数字随机验证码！
        String yzm = Integer.toString(100000 + (int) (Math.random() * ((999999 - 100000) + 1)));

        System.out.println("yzm = " + yzm);
        System.out.println("sms" + tel);

        //发送短信！
        String Msg = txSmsTemplate.sendMesModel(tel, yzm);

        System.out.println(Msg);

        //将手机号和验证码放到Redis中
        redisUtils.set(tel + yzm_reset, yzm, 300L);

        return "短信发送成功";
    }

    /**
     * 重置密码
     *
     * @param user
     * @param yzm
     * @return 是否重置成功
     */
    @RequestMapping("/reset")
    public String reset(User user, String yzm) {

        //检查无效手机号，减轻数据库负担，和验证码安全！
        if (!MobileUtils.isMobileNO(user.getTel())) {
            return "手机号格式不正确！无法发送重置密码！";
        }

        //检测账号是否存在，防止前台没有阻止用户使用未注册的手机号获取获取验证码！
        if (userService.isUser(user.getTel())) {
            return "账号不存在，不允许重置密码!";
        }

        if (!yzm.equals(redisUtils.get(user.getTel() + yzm_reset))) {
            return "验证码错误！";
        }

        boolean reset = userService.reset(user);

        if (reset) {
            //修改成功后从redis中清除验证码！
            redisUtils.del(user.getTel());
            return "修改成功！";
        } else {
            return "修改失败！";
        }
    }

    /**
     * 获取该User信息
     *
     * @param id
     * @return 该User信息
     */
    @SneakyThrows
    @PostMapping("/user/getUser/{id}")
    public CommonResult<String> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            String res = mapper.writeValueAsString(user);
            return new CommonResult<>(200, res);
        } else {
            return new CommonResult<>(500, "此用户不存在");
        }
    }

    /**
     * 判断是否登录
     *
     * @param request
     * @return 判断是否登录
     */
    @GetMapping("/isLogin")
    public boolean isLogin(HttpServletRequest request) {
        try {
            Long.valueOf((String) request.getSession().getAttribute("userId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 通过id获取该用户信息
     *
     * @param userId
     * @return 用户信息的json数据
     * @throws JsonProcessingException
     */
    @RequestMapping("/getInfo/{userId}")
    public CommonResult<String> getInfo(@PathVariable("userId") Long userId) throws JsonProcessingException {

        System.out.println("userId = " + userId);

        User user = userService.getUser(userId);
        if (user != null) {
            ObjectNode node = userToObjectNodeUtils.userToNode(user);
            return new CommonResult<>(200, mapper.writeValueAsString(node));
        } else {
            return new CommonResult<>(500, "用户不存在！");
        }

    }

    /**
     * 获取该用户所有的粉丝信息
     *
     * @param userId
     * @return 所有粉丝信息的json数据
     */
    @RequestMapping("/getFans/{userId}")
    public Map getFans(@PathVariable("userId") Long userId) {

        ArrayList<ObjectNode> list = new ArrayList<>();

        List<User> users = userService.getFans(userId);

        for (User user : users) {
            ObjectNode node = userToObjectNodeUtils.userToNode(user);
            list.add(node);
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("data", list);
        return result;

    }

    /**
     * 获取该用户订阅的所有用户信息
     *
     * @param userId
     * @return 所有订阅的用户的信息的json数据
     */
    @RequestMapping("/getSub/{userId}")
    public Map getSub(@PathVariable("userId") Long userId) {

        ArrayList<ObjectNode> list = new ArrayList<>();

        List<User> users = userService.getSub(userId);

        for (User user : users) {
            ObjectNode node = userToObjectNodeUtils.userToNode(user);
            list.add(node);
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("data", list);
        return result;

    }

}
