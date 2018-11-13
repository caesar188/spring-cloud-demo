package com.migu.consumer.cache;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@ConfigurationProperties(prefix = "cache.customized")
@EnableConfigurationProperties
@Data
public class SpringCacheConfig {

    private long defualtExpiration;

    @Bean
    public RedisCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        RedisCacheManager cacheManager = new CustomizedRedisManager(redisTemplate);
        cacheManager.setUsePrefix(false);
        // 设置默认失效时间
        cacheManager.setDefaultExpiration(getDefualtExpiration());
        return cacheManager;
    }
}
