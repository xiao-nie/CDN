//package cn.awall.awalladmin.service.impl;
//
//import cn.awall.awalladmin.dao.ArticleMapper;
//import cn.awall.awalladmin.utils.RedisUtils;
//import com.google.common.collect.Maps;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//
//@Component
//public class HotServiceImpl {
//
//    @Autowired
//    private ArticleMapper articleMapper;
//
//    @Autowired
//    private RedisUtils redisUtils;
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    private static final Integer ZAN = 4;//点赞加热度
//    private static final Integer ZAN_TIME = 40;//点赞延长失效时间
//    private static final Integer PING = 4;//评论延长失效时间
//    private static final Integer PING_TIME = 40;//评论延长失效时间
//    private static final Integer YD = 2;//阅读延长失效时间
//    private static final Integer YD_TIME = 20;//阅读延长失效时间
//    private static final Integer INIT_TIME = 600;//初始化失效时间
//    private static final Integer N = 2;//比率
//
//    /**
//     * 计算存储文章热度
//     * @param key  文章id
//     * @param type 热度上升类型
//     */
//    public void heating(String key, String type) {
//
//        //历史热度的key
//        String top = key + "_top";
//
//        //Redis中是否存在该Key
//        if (redisUtils.hasKey(key)) {
//
//            //获取当前失效时间
//            long expire = redisUtils.getExpire(key);
//
//            //获取当前键值
//            Integer v = (Integer) redisUtils.get(key);
//
//            //获取历史热度
//            Integer history = (Integer) redisUtils.get(top);
//
//            //本次比率
//            int n = 1;
//
//            //如果当前热度小于历史热度
//            if (history > (v / N)) {
//                n = N;
//            }
//
//            //热度上升
//            if (type.equals("zan")) {
//                v += (ZAN * n);
//                expire += (ZAN_TIME * n);
//            } else if (type.equals("ping")) {
//                v += (PING * n);
//                expire += (PING_TIME * n);
//            } else {
//                v += (YD * n);
//                expire += (YD_TIME * n);
//            }
//
//            //写入Redis
//            redisUtils.set(key, v, expire);
//            redisUtils.expire(top, expire);
//
//        } else {
//
//            //去数据库获取该文章热度值
//            Long aLong = articleMapper.queryCountById(key);
//
//            //将旧的热度值存储到redis中
//            redisUtils.set(top, aLong, INIT_TIME);
//
//            //将新的热度存储到redis中
//            redisUtils.set(key, ZAN, INIT_TIME);
//
//        }
//
//    }
//
//    public Map<String, Integer> getHot() {
//
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        Set<String> keys = redisTemplate.keys("*");
//        ArrayList<String> list = new ArrayList<>(keys);
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).indexOf("top") == -1) {
//                map.put(list.get(i), (Integer) redisUtils.get(list.get(i)));
//            }
//        }
//
//        Map<String, Integer> result = Maps.newLinkedHashMap();
//        map.entrySet().stream().sorted((Comparator<? super Map.Entry<String, Integer>>) Map.Entry.comparingByValue().reversed())
//                .forEach(e -> result.put(e.getKey(), e.getValue()));
//
//        return result;
//
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
