package cn.awall.awalladmin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UrMapper {

    int addUr(@Param("userId") Long userId, @Param("roleId") Long roleId);

    int delUrById(@Param("id") Long id);

    int delUrByUserId(@Param("userId") Long userId);

    int delUrByRoleId(@Param("roleId") Long roleId);
}
