package cn.awall.awalladmin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//公告表
public class Notice {

    private Long noticeId; //id
    private String type; //公告类型 1管理员公告 2 组织公告 3 组织内部公告
    private String content; //公告内容
    private Date date; //发布时间
    private Long userId; //发布人id

}
