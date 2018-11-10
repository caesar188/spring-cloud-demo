package com.migu.service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringCloudApplication
public class ServiceB {
	public static void main(String[] args) {
		SpringApplication.run(ServiceB.class, args);
	}
}
