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
//评论表
public class Comment {

    private Long comId; //该条评论的id
    private Long userId; //评论者id
    private Long articleId; //文章id
    private String content; //评论内容
    private Date date; //评论时间
    private Long toId; //回复谁

}
