package com.cache.jetcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuzhenke
 * @date 2018/10/29
 */
@SpringBootApplication
public class JetCacheMain {

    public static void main(String[] args) {
        SpringApplication.run(JetCacheMain.class,args);

        System.out.println("JetCacheMain SpringApplication finished running ......");
    }
}
