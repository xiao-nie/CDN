package cn.awall.awalladmin.dao;

import cn.awall.awalladmin.pojo.Sub;
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

}
