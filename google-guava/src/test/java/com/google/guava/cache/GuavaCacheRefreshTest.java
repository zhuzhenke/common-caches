package com.google.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import lombok.Data;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author zhuzhenke
 * @date 2019/2/17
 */
public class GuavaCacheRefreshTest {

    @Data
    public class SkuCache {
        private String skuId;
        private String skuCode;
        private Long realQuantity;
    }

    AtomicInteger loadTimes = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    @Test
    public void testCacheUse() throws Exception {
        LoadingCache<String, SkuCache> loadingCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(1000, TimeUnit.MILLISECONDS)
                //Prevent data reloading from failing, but the value of memory remains the same
                .expireAfterWrite(1500, TimeUnit.MILLISECONDS)
                .build(new CacheLoader<String, SkuCache>() {
                    @Override
                    public SkuCache load(String key) {
                        SkuCache skuCache = new SkuCache();
                        skuCache.setSkuCode(key + "---" + (loadTimes.incrementAndGet()));
                        skuCache.setSkuId(key);
                        skuCache.setRealQuantity(100L);
                        System.out.println("load..." + key);
                        return skuCache;
                    }

                    @Override
                    public ListenableFuture<SkuCache> reload(String key, SkuCache oldValue) throws Exception {
                        checkNotNull(key);
                        checkNotNull(oldValue);
                        System.out.println("reload...");
                        //Simulate time consuming operation
//                        Thread.sleep(1000);
                        return Futures.immediateFuture(load(key));
                    }
                });


        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    getValue(loadingCache);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.in.read();
        System.out.println("finish");
    }


    private void getValue(LoadingCache<String, SkuCache> loadingCache) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(300l);
            System.out.println(loadingCache.get("sku").toString() + " - " + count.incrementAndGet());
        }
    }
}
