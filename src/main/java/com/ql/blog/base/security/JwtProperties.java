package com.ql.blog.base.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * jwt属性
 *
 * @author wanqiuli
 * @date 2022/7/9 21:20
 */
@Data
@Configuration
@ConfigurationProperties(prefix = JwtProperties.PREFIX)
public class JwtProperties {
    public static final String PREFIX = "jwt";

    private String tokenHead;
    private String tokenHeader;
    private String secret;
    private Long expiration;
}
