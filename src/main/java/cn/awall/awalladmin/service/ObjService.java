package cn.awall.awalladmin.service;

import cn.awall.awalladmin.pojo.Obj;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ObjService {

    //通过id查询本批次信息
    Obj queryById(String id);

}
