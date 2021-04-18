package cn.awall.awalladmin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UFile {

    private Integer id;
    private String url;
    private String path;
    private String uDate;
    private String username;
    private String ip;

    public UFile(String url, String path){
        this.url = url;
        this.path = path;
    }
}
