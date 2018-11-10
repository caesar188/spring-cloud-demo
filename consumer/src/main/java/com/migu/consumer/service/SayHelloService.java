package com.migu.consumer.service;

import com.migu.consumer.client.ServiceAServiceID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 包: com.migu.consumer.service
 * 类名称: SayHelloService.java
 * 类描述: (这里用一句话描述这个类的作用)
 * 创建人: guhao guhao@migu.cn
 * 创建时间: 2017/9/27 13:12
 */
@Service
public class SayHelloService {


/*    @Autowired
    private ServiceAURL serviceAURL;*/

    @Autowired
    private ServiceAServiceID serviceAServiceID;


    @Autowired
    protected RedisTemplate redisTemplate;

/*
    @Autowired
    private StringRedisTemplate stringRedisTemplate;//操作key-value都是字符串
*/

    public String sayHello(String name){
        //serviceAURL.sayHello(name);
        //serviceaurl.sayhellopost(name);
        //String returnMsg = serviceAServiceID.sayHello(name);
        return serviceAServiceID.sayHelloPost(name).toString();
    }
}
