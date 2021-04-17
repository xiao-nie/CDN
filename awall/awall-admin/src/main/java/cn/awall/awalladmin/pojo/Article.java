package cn.awall.awalladmin.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
//文章表
public class Article {

    private Long articleId; //id
    private Long userId; //文章发布者
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date date; //发布时间
    private String content; //内容
    private String tag; //话题
    private String url; //文章地址
    private String classify; //分类
    private Integer star; //点赞
    private Long count; //浏览量
    private String imgs;//图片的地址

}
