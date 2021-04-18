package cn.awall.awalladmin.service.impl;

import cn.awall.awalladmin.dao.ObjMapper;
import cn.awall.awalladmin.pojo.Obj;
import cn.awall.awalladmin.service.ObjService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Mapper
@Repository
public class ObjServiceImpl implements ObjService {

    @Resource
    ObjMapper objMapper;

    @Override
    public Obj queryById(String id) {
        Obj obj = objMapper.queryById(id);
        return obj;
    }
}
