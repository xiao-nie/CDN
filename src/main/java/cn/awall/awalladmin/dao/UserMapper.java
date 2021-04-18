package cn.awall.awalladmin.dao;

import cn.awall.awalladmin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    // 查所有user
    List<User> queryUsers();

    // 按分页查
    List<User> queryUsersPage(@Param("index") Integer index, @Param("len") Integer len);

    // 通过id查
    User findUserById(@Param("userId") Long userId);

    // 通过username查
    User findUserByTel(@Param("tel") String tel);

    // 通过id删除
    int delUserById(@Param("userId") Integer userId);

    // 添加User
    int addUser(User user);

    // 通过id修改
    int updateUserById(User user);

    // 通过tel修改密码和盐
    int updateUserByTel(User user);

    // 用map修改
    int updateUserByMap(Map map);

    //通过手机号查询此人是否存在
    int queryByIdCount(String tel);

    //通过手机号去查询此人加密前的盐
    String querySaltByTel(String tel);

    //通过账号密码登录
    int queryLogin(User user);

    //通过id查询此人是否存在
    int isUserById(Long userId);

}
