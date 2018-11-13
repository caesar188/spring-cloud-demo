package com.migu.consumer.cache;

import com.migu.consumer.aspect.LogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisOperations;

import java.util.concurrent.Callable;

/**
 * 自定义的RedisCache类，用于redis操作日志打印
 */
public class RedisCacheWrapper extends RedisCache {

    private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);

    /**
     * Constructs a new {@link RedisCacheWrapper} instance.
     *
     * @param name cache name
     * @param prefix
     * @param redisOperations
     * @param expiration
     */
    public   RedisCacheWrapper(String name, byte[] prefix, RedisOperations<? extends Object, ? extends Object> redisOperations,
                               long expiration){
        super(name,prefix,redisOperations,expiration);
    }

    /**
     * Constructs a new {@link RedisCacheWrapper} instance.
     *
     * @param name cache name
     * @param prefix must not be {@literal null} or empty.
     * @param redisOperations
     * @param expiration
     * @param allowNullValues
     * @since 1.8
     */
    public   RedisCacheWrapper(String name, byte[] prefix, RedisOperations<? extends Object, ? extends Object> redisOperations,
    long expiration, boolean allowNullValues){
        super(name,prefix,redisOperations,expiration,allowNullValues);
    }

    @Override
    public ValueWrapper get(Object key) {
        try {
            ValueWrapper valueWrapper = super.get(key);
            LOG.info(getName()+" redis cache get {}:{}", key,valueWrapper==null ? "null" : valueWrapper.get());
            return valueWrapper;
        } catch (Exception e) {
            LOG.error(getName()+" redis cache get key: {} error, errmsg: {}", key, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public <T> T get(Object key, Class<T> aClass) {
         LOG.info(getName()+" redis cache get key: {}, clazz: {}", key, aClass);
        try {
            return super.get(key, aClass);
        } catch (Exception e) {
            LOG.error(getName()+" redis cache get key: {}, clazz: {} error, errmsg: {}", key, aClass, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public <T> T get(Object key, Callable<T> callable) {
         LOG.info(getName()+" redis cache get key: {}", key);
        try {
            return super.get(key, callable);
        } catch (Exception e) {
            LOG.error(getName()+" redis cache get key: {} error, errmsg: {}", key, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void put(final Object key, final Object value) {
        try {
            LOG.info(getName()+" redis cache put {}:{}", key, value);
            super.put(key, value);
        } catch (Exception e) {
            LOG.error(getName()+" redis cache put {}:{} error, errmsg: {}", key, value, e.getMessage(), e);
        }
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, final Object value) {
        try {
            LOG.info(getName()+" redis cache putIfAbsent {}:{}", key, value);
            return super.putIfAbsent(key, value);
        } catch (Exception e) {
            LOG.error(getName()+" redis cache putIfAbsent {}:{} error, errmsg: {}", key, value, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String getName() {
            return super.getName();
    }

    @Override
    public void evict(Object key) {
        try {
            super.evict(key);
            LOG.info(getName()+" redis cache evict key: {}", key);
        } catch (Exception e) {
            LOG.error(getName()+" redis cache evict key: {} error, errmsg: {}", key, e.getMessage(), e);
        }
    }

    @Override
    public void clear() {
        try {
            super.clear();
            LOG.info(getName()+" redis cache clear");
        } catch (Exception e) {
            LOG.error(getName()+" redis cache clear error, errmsg: {}", e.getMessage(), e);
        }
    }


}
