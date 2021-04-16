package cn.awall.awalladmin.dao;


import cn.awall.awalladmin.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RoleMapper {

    // 查所有Role
    List<Role> queryRoles();

    // 按分页查
    List<Role> queryRolePage(@Param("index") Integer index, @Param("len") Integer len);

    // 通过id查
    Role findRoleById(@Param("roleId") String userId);

    Role findRoleByUserId(@Param("userId") Long userId);

    // 通过username查
    Role findRoleByUsername(@Param("username") String username);

    // 通过id删除
    int delUserById(@Param("roleId") Long userId);

    // 添加Role
    int addRole(Role role);

    // 通过id修改
    int updateRoleById(Role role);

    // 用map修改
    int updateRoleByMap(Map map);
}
