package com.cache.springcache;

import com.common.cache.constants.CategoryCacheConstants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
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
    @Qualifier(CategoryCacheConstants.CACHE_MANAGER_CONCURRENTMAP)
    @Primary
    ConcurrentMapCacheManager concurrentMapCacheManager() {
        return new ConcurrentMapCacheManager();
    }


    @Bean
    @Qualifier(CategoryCacheConstants.CACHE_MANAGER_GUAVA)
    GuavaCacheManager guavaCacheManager() {
        GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
        guavaCacheManager.setCacheSpecification("maximumSize=500,expireAfterWrite=1m");
        return guavaCacheManager;
    }
}
