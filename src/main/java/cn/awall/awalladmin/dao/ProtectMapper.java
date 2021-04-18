package cn.awall.awalladmin.dao;

import cn.awall.awalladmin.pojo.Protect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProtectMapper {

    //插入数据
    public int addProtect(Protect protect);

    //通过id删除数据
    public int deleteProtectById(Long protectId);

    //修改数据
    public int updateProtect(Protect protect);

    //通过条件查询数据
    public List<Protect> selectProtect(Protect protect);

}
