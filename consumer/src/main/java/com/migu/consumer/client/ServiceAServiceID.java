package com.migu.consumer.client;

import com.migu.consumer.client.fallback.ServiceAServiceIDFallbackFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * query subscription from charge-center
 * 暂不做转换，统一复制原子层api
 * @author Tony Wang
 *
 */
@FeignClient(name = "serviceA", fallbackFactory = ServiceAServiceIDFallbackFactory.class)
public interface ServiceAServiceID  {

    @Cacheable(key = "#p0")
    @RequestMapping(value="/hello/get/{name}", method = RequestMethod.GET)
    String sayHello(@PathVariable("name") String name);

    @Cacheable(value = {"names#30#5"},key = "#p0" ,unless = "#result.get('resultcode') eq '80000'")
    @RequestMapping(value="/hello/post", method = RequestMethod.POST)
    Map sayHelloPost(@RequestBody String name);

}