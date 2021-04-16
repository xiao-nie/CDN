package cn.awall.awalladmin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//维权信息表
public class Protect {

    private Long protectId; //id
    private String title; //标题
    private String status; //状态
    private Long articleId; //文章id

}
