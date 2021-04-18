package cn.awall.awalladmin.dao;

import cn.awall.awalladmin.pojo.Group;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GroupMapper {

    //添加数据
    public int addGroup(Group group);

    //通过id查询删除
    public int deleteGroupByTd(Long groupId);

    //修改数据
    public int updateGroupById(Group group);

    //通过条件查询数据
    public List<Group> selectGroup(Group group);

}