package com.migu.consumer.controller;

import com.migu.consumer.api.SayHelloApi;
import com.migu.consumer.service.SayHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包: com.migu.consumer.controller
 * 类名称: SayHelloController.java
 * 类描述: (这里用一句话描述这个类的作用)
 * 创建人: guhao guhao@migu.cn
 * 创建时间: 2017/9/27 13:12
 */
@RestController
@CacheConfig(cacheNames = {"names"})
public class SayHelloController implements SayHelloApi{

    @Autowired
    private SayHelloService sayHelloService;

    @Override
    public String sayHelloToA(String name) {
        return sayHelloService.sayHello(name);
    }

    @RequestMapping(value="/clean",method = RequestMethod.GET)
    //方法调用前清空所有缓存
    @CacheEvict(allEntries = true)
    public String clean(){
        return "清空缓存";
    }
}
