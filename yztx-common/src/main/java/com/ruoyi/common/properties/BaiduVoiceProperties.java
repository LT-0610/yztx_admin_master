package com.ruoyi.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "baidu")
@Data
public class BaiduVoiceProperties {
    private String appid;
    private String apikey;
    private String secretkey;

}
