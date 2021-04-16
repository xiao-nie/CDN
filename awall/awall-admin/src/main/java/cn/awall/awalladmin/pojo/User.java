package cn.awall.awalladmin.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private Long userId;//id
    private String tel;
    private String password;
    private String headImg;
    private String nikename;
    private String signature;
    private String hobby;
    private String college;
    private String realName;
    @JsonFormat(pattern = "yyyy-MM-dd mm:hh:ss", timezone = "GMT+8")
    private Date createTime;
    private String ac;
    @JsonFormat(pattern = "yyyy-MM-dd mm:hh:ss", timezone = "GMT+8")
    private Date loginTime;
    private String loginIp;
    private String backgroundImg;
    private String salt;
}
