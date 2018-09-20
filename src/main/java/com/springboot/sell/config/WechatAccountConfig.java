package com.springboot.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private  String mpAPPId;
    private  String mpAppSecret;
    private  String openAPPId;
    private  String openAppSecret;
    private String mchId;
    private String mchKey;
    private String keyPath;
    private SSLContext sslContext;
    private String notifyUrl;
}
