package com.cache.springcache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author zhuzhenke
 * @date 2018/11/4
 */
@Configuration
public class CacheConfiguration {

    @Bean
    @Qualifier("concurrentMapCacheManager")
    @Primary
    ConcurrentMapCacheManager concurrentMapCacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
