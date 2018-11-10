package com.migu.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 包: com.migu.config
 * 类名称: Server.java
 * 类描述: (这里用一句话描述这个类的作用)
 * 创建人: guhao guhao@migu.cn
 * 创建时间: 2017/9/26 22:09
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class Config {


    public static void main(String[] args) {
        SpringApplication.run(Config.class, args);
    }
}
