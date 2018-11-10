package com.migu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka1 {
    public static void main( String[] args ) {
        SpringApplication.run(Eureka1.class, args);
    }
}
