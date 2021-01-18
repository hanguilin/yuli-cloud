package cn.javayuli.cloud.common.core.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @description: Spring Cache Redis
 * @author: HanGuiLin
 * @createDate: 2021/1/16
 * @version: 1.0
 */
@EnableCaching
@Configuration
public class RedisCacheConfiguration {

    /**
     * 创建redis CacheManager
     * @param redisConnectionFactory redis连接工厂
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        return RedisCacheManager.create(redisConnectionFactory);
    }

}
