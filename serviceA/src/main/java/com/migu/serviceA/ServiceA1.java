package com.migu.serviceA;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@EnableEurekaClient
@SpringCloudApplication
public class ServiceA1 {

    @RestController
    @RequestMapping(value = "/hello")
    class HelloController {

        int a = 10;

        @RequestMapping("/get/{name}")
        @ResponseBody
        String sayHello(@PathVariable String name) {
            try {
                Thread.sleep(a);
                System.out.println("service slept for " + String.valueOf(a) + " ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("service A is called");
            return "Hello " + name + " ,this is service A!";
        }


        @RequestMapping(value = "/post", method = RequestMethod.POST)
        Map sayHelloPost(@RequestBody String name) {
            try {
                Thread.sleep(a);
                System.out.println("service slept for " + String.valueOf(a) + " ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("service A post is called");
            return new HashMap() {{
                put("resultcode", "8000");
                put("resultmsg", "Hello " + name + " ,this is service A!");
            }};
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceA1.class, args);
    }
}
