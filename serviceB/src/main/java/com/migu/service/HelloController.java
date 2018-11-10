package com.migu.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
class HelloController {
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    String sayHelloPost(@RequestBody String name) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("service B [post] is called");
        return "Hello " + name + " ,this is service B!";
    }
}
