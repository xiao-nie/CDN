package cn.awall.awalladmin.service;

import cn.awall.awalladmin.pojo.User;

import java.util.Map;

public interface UserService {

    //是否允许注册
    boolean isUser(String tel);

    //将密码加密
    String encryption(String salt,String password);

    //注册账号！
    boolean register(User user);

    //登录账号
    boolean login(User user);

    //重置密码
    boolean reset(User user);
    //获取单个user信息
    User getUser(Long id);

    //获取当前用户的所有信息
    User findUserById(Long userId);

    //判断盖id是否存在
    boolean isUserById(Long userId);

}
