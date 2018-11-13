package com.migu.consumer.cache;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisOperations;


/**
 * 自定义的RedisCacheManager，支持注解方式通过SpEL定义缓存失效时间.
 */
public class CustomizedRedisManager extends RedisCacheManager {

    private static final String SEPARATOR = "#";

    /**
     * SpEL标示符
     */
    private static final String MARK = "$";

    @Autowired
    DefaultListableBeanFactory beanFactory;


    public CustomizedRedisManager(RedisOperations redisOperations) {
        super(redisOperations);
    }

    @Override
    protected RedisCache createCache(String cacheName) {
        // 解析cache name 和 spel
        String[] values = cacheName.split(SEPARATOR);

        long expiration = computeExpiration(values);
        return new RedisCacheWrapper(values[0], (isUsePrefix() ? getCachePrefix().prefix(cacheName) : null), getRedisOperations(), expiration);
    }

    private long computeExpiration(String[] values) {

        if (values.length > 1) {

            String expirationStr = values[1];
            if (!StringUtils.isEmpty(expirationStr)) {
                // 支持配置过期时间使用EL表达式读取配置文件时间
                if (expirationStr.contains(MARK)) {
                    expirationStr = beanFactory.resolveEmbeddedValue(expirationStr);
                }

                return Long.parseLong(expirationStr);
            }
        }
        // 使用默认的过期时间而不指定特殊时间，则可以直接@Cacheable(cacheNames="name")，不需要加'#过期时间'了
        return super.computeExpiration(values[0]);
    }
}
