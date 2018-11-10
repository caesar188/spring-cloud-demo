package com.migu.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 包: com.migu.consumer
 * 类名称: SayHello.java
 * 类描述: (这里用一句话描述这个类的作用)
 * 创建人: guhao guhao@migu.cn
 * 创建时间: 2017/9/27 13:16
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableCaching
public class SayHello {
    public static void main(String[] args) {
        SpringApplication.run(SayHello.class, args);
    }
}
