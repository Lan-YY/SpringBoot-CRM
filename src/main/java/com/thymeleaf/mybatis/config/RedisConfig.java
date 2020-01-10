package com.thymeleaf.mybatis.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thymeleaf.mybatis.mapper.MyObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;


/**
 * Package: com.thymeleaf.mybatis.config
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/9 11:34
 * 自定义缓存读写机制
 */
@Configuration
@EnableCaching //开启缓存
public class RedisConfig extends CachingConfigurerSupport {
    /**
     *  自定义生成key的规则
     *   缓存对象集合中，缓存是以key-value 形式保存
     *   当不指定缓存的key 时，springboot 会使用simpleKeyGenerator 生成key
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                //格式化缓存 key字符串
                StringBuilder stringBuilder =new StringBuilder();
                // 追加类名
                stringBuilder.append(target.getClass().getName());
                // 追加方法名
                stringBuilder.append(method.getName());
                for (Object obj : params) {
                    stringBuilder.append(obj.toString());
                }
                System.out.println("调用Redis缓存key "+stringBuilder.toString());
                return stringBuilder.toString();
            }
        };
    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Object> redisTemplate =new RedisTemplate<>();
        // 将刚才的redis连接工厂设置到模板类中
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =new Jackson2JsonRedisSerializer(Object.class);
        MyObjectMapper objectMapper = new MyObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);

        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);


        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        redisTemplate.afterPropertiesSet();

        return  redisTemplate;
    }

    /***
     * 采用RedisCacheManager 作为缓存管理器
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory){
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        MyObjectMapper objectMapper = new MyObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 配置序列化
        RedisCacheConfiguration config= RedisCacheConfiguration.defaultCacheConfig();

        // 配置序列化（解决乱码的问题）
        RedisCacheConfiguration redisCacheConfiguration =config.serializeKeysWith
                (RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer));
        RedisCacheManager cacheManager =RedisCacheManager.builder(factory).cacheDefaults(redisCacheConfiguration.entryTtl(Duration.ofMinutes(5))).build();
        return cacheManager;
    }


}
