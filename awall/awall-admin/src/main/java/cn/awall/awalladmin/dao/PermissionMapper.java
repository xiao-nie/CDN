package cn.awall.awalladmin.dao;


import cn.awall.awalladmin.pojo.Permission;
import cn.awall.awalladmin.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
@Repository
public interface PermissionMapper {

    // 查所有Role
    List<Permission> queryPermissions();

    // 按分页查
    List<Permission> queryPermissionPage(@Param("index") Integer index, @Param("len") Integer len);

    // 通过id查
    Role findPermissionById(@Param("permissionId") String permissionId);
    Set<String> getPermissionsByUserId(@Param("userId") Long userId);

    // 通过id删除
    int delPermissionById(@Param("permissionId") Long permissionId);

    // 添加permission
    int addPermission(Permission permission);

    // 用map修改
    int updatePermissionByMap(Map map);
}
