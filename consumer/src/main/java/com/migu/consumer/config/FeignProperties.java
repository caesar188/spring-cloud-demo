package com.migu.consumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "feign.httpclient")
@Data
public class FeignProperties {
    private Integer maxConnTotal = 1000;
    private Integer maxConnPerRoute = 50;
    private Long maxIdleTime = 60L;
}
