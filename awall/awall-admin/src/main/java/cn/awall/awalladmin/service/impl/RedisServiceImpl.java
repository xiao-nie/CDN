package cn.awall.awalladmin.service.impl;

import cn.awall.awalladmin.service.RedisService;

import java.util.List;

public class RedisServiceImpl implements RedisService {
    @Override
    public void saveLikedRedis(String likedUserId, String likedPostId) {

    }

    @Override
    public void unlikeRedis(String likedUserId, String likedPostId) {

    }

    @Override
    public void delLikedRedis(String likedUserId, String likedPostId) {

    }

    @Override
    public void delCountRedis(String postId) {

    }

    @Override
    public void incrementCount(String postId) {

    }

    @Override
    public void decrementCount(String postId) {

    }

    @Override
    public List getLikedDataRedis() {
        return null;
    }

    @Override
    public List getCountRedis() {
        return null;
    }
}
