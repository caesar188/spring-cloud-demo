package com.migu.consumer.config;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.netflix.feign.ribbon.LoadBalancerFeignClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;


@EnableConfigurationProperties(FeignProperties.class)
public class FeignHttpClientProxyConf {

    @Bean
    public Client feignClient(CachingSpringLoadBalancerFactory cachingFactory,
                              SpringClientFactory clientFactory,FeignProperties feignProperties) {

        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.setMaxConnTotal(900);
        builder.setMaxConnPerRoute(40);
        builder.setProxy(new HttpHost("10.181.8.22", 10060));
        builder.evictIdleConnections(feignProperties.getMaxIdleTime().longValue(), TimeUnit.SECONDS);

        ApacheHttpClient delegate = new ApacheHttpClient(builder.build());
        return new LoadBalancerFeignClient(delegate, cachingFactory, clientFactory);
    }
}