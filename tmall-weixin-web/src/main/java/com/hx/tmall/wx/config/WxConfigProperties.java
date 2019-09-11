package com.hx.tmall.wx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * wechat mp properties
 *
 * @author Binary Wang(https://github.com/binarywang)
 */
@Configuration
@ConfigurationProperties(prefix = "mywx")
@Data
public class WxConfigProperties {
    private String wechatMpAuthorize;
}
