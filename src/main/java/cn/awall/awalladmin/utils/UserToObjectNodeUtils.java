package cn.awall.awalladmin.utils;

import cn.awall.awalladmin.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Mapper
@Repository
public class UserToObjectNodeUtils {

    @Resource
    ObjectMapper mapper;

    public ObjectNode userToNode(User user){
        com.fasterxml.jackson.databind.node.ObjectNode node = mapper.createObjectNode();
        if (user.getUserId()!=null){
            node.put("userId", user.getUserId().toString());
        }
        if (user.getTel()!=null){
            node.put("tel", user.getTel());
        }
        if (user.getHeadImg() != null) {
            node.put("headImg", user.getHeadImg());
        }
        if (user.getNikename() != null) {
            node.put("nikename", user.getNikename());
        }
        if (user.getSignature() != null) {
            node.put("signature", user.getSignature());
        }
        if (user.getHobby() != null) {
            node.put("hobby", user.getHobby());
        }
        if (user.getCollege() != null) {
            node.put("college", user.getCollege());
        }
        if (user.getRealName() != null) {
            node.put("realName", user.getRealName());
        }
        if (user.getCreateTime() != null) {
            node.put("createTime", user.getCreateTime().toString());
        }
        if (user.getAc() != null) {
            node.put("ac", user.getAc());
        }
        if (user.getLoginTime() != null) {
            node.put("loginTime", user.getLoginTime().toString());
        }
        if (user.getLoginIp() != null) {
            node.put("loginIp", user.getLoginIp());
        }
        if (user.getBackgroundImg() != null) {
            node.put("backgroundImg", user.getBackgroundImg());
        }
        return node;
    }

}
