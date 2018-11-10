package com.migu.consumer.config;

import feign.Retryer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FeignProperties.class)
public class FeignHttpClientConf {

    @Bean
    Retryer feignRetryer() {
        return  new Retryer.Default(100,1000,3);
    }

}
