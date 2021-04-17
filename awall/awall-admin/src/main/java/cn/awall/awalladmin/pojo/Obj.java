package cn.awall.awalladmin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Obj {

    private String id;
    private Date pstime;
    private Date pbtime;
    private Date ztime;
    private Date ttime;
    private Date ltime;
    private Date gstime;
    private Date gbtime;

}
