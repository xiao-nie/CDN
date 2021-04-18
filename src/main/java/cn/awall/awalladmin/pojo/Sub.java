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
//订阅表，体现作者与粉丝之间关系
public class Sub {

    private Long subId; //id
    private Long subUserId; //订阅者|粉丝
    private Long pubUserId; //发布者

}
