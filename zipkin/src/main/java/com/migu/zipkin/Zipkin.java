package com.migu.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class Zipkin
{
	public static void main(String[] args) {
		SpringApplication.run(Zipkin.class, args);
	}
}
