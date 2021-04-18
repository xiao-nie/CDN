package cn.awall.awalladmin.service;

import java.util.Map;

public interface TrainService {

    //判断用户输入的时间是否正确
    public boolean isObj(String school, String id, String entrance, String objId);

    //为用户计算填写材料所需时间
    public Map getTime(String school, String id, String entrance, String objId);

}
