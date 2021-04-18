package cn.awall.awalladmin.dao;

import cn.awall.awalladmin.pojo.Sub;
import cn.awall.awalladmin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubMapper {

    //插入数据
    public int addSub(Sub sub);

    //通过id删除数据
    public int deleteSub(Long subId);

    //修改数据
    public int updateSub(Sub sub);

    //通过条件查询数据
    public List<Sub> selectSub(Sub sub);

    //通过id查询该用户的粉丝
    List<User> queryFansById(Long pubUserId);

    //通过id查询该用户订阅的人
    List<User> querySubById(Long userId);

}
