package cn.awall.awalladmin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RpMapper {

    int addRp(@Param("permissionId") Long permissionId, @Param("roleId") Long roleId);

    int delRpById(@Param("id") Long id);

    int delRpByPermissionId(@Param("permissionId") Long userId);

    int delRpByRoleId(@Param("roleId") Long roleId);
}
