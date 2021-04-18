package cn.awall.awalladmin.dao;

import cn.awall.awalladmin.pojo.Train;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TrainMapper {

    public Train queryTrainById(String id);

}
