package cn.awall.awalladmin.service.impl;

import cn.awall.awalladmin.dao.UserMapper;
import cn.awall.awalladmin.pojo.User;
import cn.awall.awalladmin.service.UserService;
import cn.awall.awalladmin.utils.DESUtils;
import cn.awall.awalladmin.utils.Md5Utils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //是否允许注册
    @Override
    public boolean isUser(String tel) {
        int i = userMapper.queryByIdCount(tel);
        if (i == 1) return false;
        else return true;
    }

    //将密码加密
    @Override
    public String encryption(String salt,String password) {

        //将盐加密
        String salts = DESUtils.encrypt(salt);
        System.out.println("加密后的盐为：" + salts);
        //使用加密后的盐和密码拼接后md5加密
//        String enPassword = Md5Utils.encoder(password, salts);
        //为用户生成的盐为：3f7dd4
        //加密后的盐为：/KK9f6UG3I4=
        Md5Hash md5Hash = new Md5Hash(password,salts);
        System.out.println("加密后的密码为：" + md5Hash);
        return md5Hash.toString();
    }

    //注册账号！
    @Override
    public boolean register(User user) {

        //判断是否允许注册
        if (!isUser(user.getTel())) return false;

        //前端传来密码
        String password = user.getPassword();

        //为该用户生成一个随机的盐
        String salt = UUID.randomUUID().toString().substring(0, 6);

        System.out.println("为用户" + "生成的盐为：" + salt);

        //将密码加密处理
//        String enPassword = encryption(salt,password);

        //将加密后的密码和未加密的盐放进user
//        user.setPassword(enPassword);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(password,salt);
        user.setPassword(md5Hash.toString());
        //将加密后的密码和未加密的盐存到数据库
        int i = userMapper.addUser(user);
        System.out.println("impl:"+user);

        //判断是否添加成功！
        if (i == 1) {
            return true;
        } else return false;

    }

    //登录账号
    @Override
    public boolean login(User user) {

        //如果用户不存在，直接返回false
        if (isUser(user.getTel())) return false;

        //用户存在
        //获取用户的加密前的盐
        String salt = userMapper.querySaltByTel(user.getTel());

        //使用这个盐生成用户加密后的密码
        String enPassword = encryption(salt, user.getPassword());

        user.setPassword(enPassword);

        int i = userMapper.queryLogin(user);

        //判断是否登录成功！
        if (i == 1) {
            return true;
        } else return false;

    }

    //重置密码
    @Override
    public boolean reset(User user) {

        //前端传来密码
        String password = user.getPassword();

        //为该用户生成一个随机的盐
        String salt = UUID.randomUUID().toString().substring(0, 6);

        System.out.println("为用户" + "生成的盐为：" + salt);

        //将密码加密处理
        String enPassword = encryption(salt,password);

        //将加密后的密码和未加密的盐放进user
        user.setPassword(enPassword);
        user.setSalt(salt);

        int i = userMapper.updateUserByTel(user);

        //判断是否修改成功！
        if (i == 1) {
            return true;
        } else return false;

    }

    @Override
    public User getUser(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserById(Long userId) {

        if (!isUserById(userId)) {
            System.out.println("该用户不存在");
            return null;
        }

        User user = userMapper.findUserById(userId);

        return user;
    }

    @Override
    public boolean isUserById(Long userId) {
        int i = userMapper.isUserById(userId);
        if (i == 1) return true;
        return false;
    }
}









