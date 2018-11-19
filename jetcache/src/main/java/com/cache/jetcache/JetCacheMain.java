package com.cache.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhuzhenke
 * @date 2018/10/29
 */
@SpringBootApplication
@ComponentScan("com.cache.jetcache")
@EnableMethodCache(basePackages = "com.cache.jetcache")
@EnableCreateCacheAnnotation
public class JetCacheMain {

    public static void main(String[] args) {
        SpringApplication.run(JetCacheMain.class, args);
        System.out.println("JetCacheMain SpringApplication finished running ......");
    }
}
