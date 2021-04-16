package cn.awall.awalladmin;

import cn.awall.awalladmin.dao.UserMapper;
import cn.awall.awalladmin.pojo.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class UserMapperTest {

    static SqlSessionFactory sqlSessionFactory;

    @Resource
    UserMapper userMapper;

    @Test
    void testUser(){
        List<User> users = userMapper.queryUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void  addUser(){
        Date date = new Date();
        User user = new User();
        user.setAc("认证");
        user.setBackgroundImg("http://");
        user.setCollege("信息工程学院");
        user.setCreateTime(date);
        user.setHobby("java");
        user.setLoginIp("127.0.0.1");
        user.setLoginTime(date);
        user.setNikename("TabTan");
        user.setPassword("123456");
        user.setRealName("谈培正");
        user.setSalt("123");
        user.setTel("12324235231");
        int i = userMapper.addUser(user);
        System.out.println(user);
    }

    @Test
    void testDel(){
        int i = userMapper.delUserById(4);
        System.out.println(i);
    }

    @Test
    void testUpdate(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",6);
        map.put("headImg","headImg");
        int i = userMapper.updateUserByMap(map);
        System.out.println(i);
    }

    @Test
    void test(){
        int i = userMapper.queryByIdCount("18226165001");
        System.out.println(i);
    }

    @Test
    void test1(){
        Md5Hash aaaaaa = new Md5Hash("aaaaaa", "22135c");
        System.out.println(aaaaaa.toString());//5bc53ccc10e63ce84859c723540c6bcc
    }

}
