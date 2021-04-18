package cn.awall.awalladmin.dao;

import cn.awall.awalladmin.pojo.Obj;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ObjMapper {

    //通过id查询本批次的信息
    Obj queryById(String id);

}
