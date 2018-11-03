package com.google.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author zhuzhenke
 * @date 2018/9/29
 */
public class CacheTest {

    @Test
    public void testCacheUse() throws Exception{
        LoadingCache<String, SkuCache> loadingCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(5, TimeUnit.SECONDS)
                .build(new CacheLoader<String, SkuCache>() {
                    @Override
                    public SkuCache load(String key) {
                        SkuCache skuCache = new SkuCache();
                        skuCache.setSkuCode(key);
                        skuCache.setSkuId(key);
                        skuCache.setRealQuantity(100L);
                        return skuCache;
                    }
                    @Override
                    public ListenableFuture<SkuCache> reload(String key, SkuCache oldValue) throws Exception {
                        checkNotNull(key);
                        checkNotNull(oldValue);
                        return Futures.immediateFuture(load(key));
                    }
                });

        SkuCache skuCache = loadingCache.get("sku");
        System.out.println(skuCache);
        skuCache.setSkuCode(skuCache.getSkuCode() + "-modified");
        SkuCache skuCache2 = loadingCache.get("sku");
        System.out.println(skuCache2);

    }
}
