package com.google.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuzhenke
 * @date 2019/4/26
 */
public class GuavaRefreshWhenCacheIsNullTest {

    private CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
            .refreshAfterWrite(10, TimeUnit.SECONDS)
            .expireAfterWrite(20, TimeUnit.SECONDS);

    @Test
    public void testGuavaRefreshWhenCacheIsNullThrowsException() {

        LoadingCache<String, String> refreshWarehouseCache = cacheBuilder.build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                if ("ValueOfKeyIsNull".equals(key)) {
                    return null;
                }
                return "1234567890";
            }

            @Override
            public ListenableFuture<String> reload(String key, String oldValue) {
                System.out.println("testGuavaRefresh reload : key=" + key);
                return Futures.immediateFuture(load(key));
            }
        });

        try {
            String myValue = refreshWarehouseCache.get("myKey");
            Assert.assertEquals("1234567890", myValue);

            //throws Exception
            myValue = refreshWarehouseCache.get("ValueOfKeyIsNull");
            Assert.assertNull(myValue);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGuavaRefreshWhenCacheIsNullReturnNull() {

        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
                .refreshAfterWrite(10, TimeUnit.SECONDS)
                .expireAfterWrite(20, TimeUnit.SECONDS);

        LoadingCache<String, Optional<String>> refreshWarehouseCache = cacheBuilder.build(new CacheLoader<String, Optional<String>>() {
            @Override
            public Optional<String> load(String key) {
                if ("ValueOfKeyIsNull".equals(key)) {
                    return Optional.empty();
                }
                return Optional.of("1234567890");
            }

            @Override
            public ListenableFuture<Optional<String>> reload(String key, Optional<String> oldValue) {
                System.out.println("testGuavaRefresh reload : key=" + key);
                return Futures.immediateFuture(load(key));
            }
        });

        try {
            Optional<String> myValue = refreshWarehouseCache.get("myKey");
            Assert.assertEquals("1234567890", myValue.orElse(null));

            myValue = refreshWarehouseCache.get("ValueOfKeyIsNull");
            //get myValue is null
            Assert.assertNull(myValue.orElse(null));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
