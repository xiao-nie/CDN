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
//组织的成员表
public class Group {

    private Long groupId; //id
    private Long userId; //成员id
    private Long postId; //组织id

}