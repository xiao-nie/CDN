package cn.awall.awalladmin.service.impl;

import cn.awall.awalladmin.dao.TrainMapper;
import cn.awall.awalladmin.pojo.Train;
import cn.awall.awalladmin.service.TrainService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Mapper
@Repository
public class TrainServiceImpl implements TrainService {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    TrainMapper trainMapper;

    @Override
    public boolean isObj(String school,String id, String entrance, String objId) {
        Date en = null;
        try {
            //将前端传来的入学时间转化为Date类型
            en = sdf.parse(entrance);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //通过这个积极分子培养批次查询培养时间
        Train train = trainMapper.queryTrainById(id);

        //首先判断用户是否在学校上的党课

        //用户在学校上的党课
        if (school.equals("true")){
            if(en.after(train.getStime())){
                System.out.println("在学校上党课时间不能早于开学时间！");
                return false;
            }
        }
        if (Integer.parseInt(objId)<Integer.parseInt(id)){
            System.out.println("上党课不满一年，无法发展！");
            return false;
        }

        return true;

    }

    @Override
    public Map getTime(String school,String id, String entrance,String objId) {

        //通过这个积极分子培养批次查询培养时间
        Train train = trainMapper.queryTrainById(id);

        Date en = null;

        //创建Map用来储存最后结果
        Map<String, Date> map = new HashMap<String, Date>();
        try {
            //将前端传来的入学时间转化为Date类型
            en = sdf.parse(entrance);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //将入学时间存储到Map中
        map.put("入学时间", en);

        Calendar cal = Calendar.getInstance();
        cal.setTime(train.getStime());
        //将开始培训时间往前推一年
        cal.add(Calendar.YEAR, -1);
        Date positive = cal.getTime();

        if (school.equals("true")){
            //判断推一年是否推到了入学前
            if (positive.before(en)) {
                positive = en;
            }
        }

        map.put("申请入党时间",positive);
        map.put("个人自传时间",positive);

        cal.setTime(positive);
        cal.add(Calendar.MONTH, 1);

        map.put("列为积极分子时间",cal.getTime());

        return map;
    }
}