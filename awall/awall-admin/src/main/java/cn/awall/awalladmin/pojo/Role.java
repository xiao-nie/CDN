package cn.awall.awalladmin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Role {
    private Long roleId;
    private String roleName;
    private String roleDesc;
}
