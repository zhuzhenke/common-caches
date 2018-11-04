package com.cache.springcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhuzhenke
 * @date 2018/10/29
 */
@SpringBootApplication
@ComponentScan("com.cache.springcache")
@EnableCaching()
public class SpringCacheMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheMain.class, args);

        System.out.println("SpringCacheMain SpringApplication finished running ......");
    }
}
