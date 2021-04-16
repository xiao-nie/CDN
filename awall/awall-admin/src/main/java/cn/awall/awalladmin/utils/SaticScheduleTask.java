package cn.awall.awalladmin.utils;

import cn.awall.awalladmin.dao.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //3.添加定时任务
    @Scheduled(cron = "0/30 * * * * ?")
    private void configureTasks() {

        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());

        //获取此数据库中所有kv
        Set<String> keys = redisTemplate.keys("*");
        assert keys != null;
        ArrayList<String> list = new ArrayList<>(keys);
        //千层饼开始了
        for (String s : list) {
            //判断dao
            if (s.contains("dao")) {
                //获取id
                String id = s.split("_")[0];
                //判断id是否失效
                if (!redisUtils.hasKey(id + "_id")) {
                    //获取本次产生的热度
                    Integer count = (Integer) redisUtils.get(id + "_dao");
                    //判断是否超过历史热度
                    if (count > (Integer) redisUtils.get(id + "_top")) {
                        //如果超过，持久化
                        articleMapper.updateCountById(Long.parseLong(id), count.longValue());
                    }
                    //删除该id的dao
                    redisUtils.del(id + "_dao");
                    redisUtils.del(id + "_top");
                }
            }
        }

    }
}












