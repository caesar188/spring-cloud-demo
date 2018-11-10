package com.migu.consumer.client.fallback;

import com.migu.consumer.client.ServiceAServiceID;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ServiceAServiceIDFallbackFactory implements FallbackFactory<ServiceAServiceID> {

    public ServiceAServiceID create(Throwable cause) {
        return new ServiceAServiceID(){
            public String sayHello(String name){
                return "ServiceA GET 降级服务 cause:"+cause.getMessage();
            }

            public Map sayHelloPost(String name){

                return new HashMap<String, String>(){{
                    put("resultcode","80001");
                    put("resultmsg","降级");
                }};

            }
        };
    }
}
