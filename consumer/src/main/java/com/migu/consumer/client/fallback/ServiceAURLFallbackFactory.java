package com.migu.consumer.client.fallback;

import com.migu.consumer.client.ServiceAURL;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceAURLFallbackFactory implements FallbackFactory<ServiceAURL> {

    public ServiceAURL create(Throwable cause) {
        return new ServiceAURL(){
            public String sayHello(String name){
                return "ServiceA GET 降级服务 cause:"+cause.getMessage();
            }

            public String sayHelloPost(String name){
                return "ServiceA POST 降级服务 cause:"+cause.getMessage();
            }
        };
    }
}
