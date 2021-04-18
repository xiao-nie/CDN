package cn.awall.awalladmin.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 腾讯云发送短信
 * 参数配置类
 */
@Data
// 读取application.yml中的项目名称.txsms的属性
@ConfigurationProperties(prefix = "txsms")

public class TxProperties {
    // AppId  1400开头的
    private int AppId;
    // 短信应用SDK AppKey
    private String AppKey;
    // 短信模板ID
    private int TemplateId;
    // 签名
    private String signName;
    //有效时间
    private String min;

}

