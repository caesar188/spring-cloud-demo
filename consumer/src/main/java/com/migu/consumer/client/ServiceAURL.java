package com.migu.consumer.client;

import com.migu.consumer.client.fallback.ServiceAURLFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "serviceAURL", url = "http://localhost:8081", fallbackFactory = ServiceAURLFallbackFactory.class)
public interface ServiceAURL {
    @RequestMapping(value="/hello/get/{name}", method = RequestMethod.GET)
    String sayHello(@PathVariable("name") String name);

    @RequestMapping(value="/hello/post", method = RequestMethod.POST)
    String sayHelloPost(@RequestBody String name);
}