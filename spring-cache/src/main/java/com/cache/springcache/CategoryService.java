package com.cache.springcache;

import com.cache.springcache.dto.Category;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * @author zhuzhenke
 * @date 2018/10/29
 */
@Service
public class CategoryService {
    @Caching(evict = {@CacheEvict(value = CategoryCacheConstants.CATEGORY_DOMAIN, key = "category.getCategoryCacheKey()", beforeInvocation = true)})
    public int add(Category category) {
        System.out.println("Cache became invalid,value:" + CategoryCacheConstants.CATEGORY_DOMAIN
                + ",key:" + category.getCategoryCacheKey());
        return 1;
    }

    @Caching(evict = {@CacheEvict(value = CategoryCacheConstants.CATEGORY_DOMAIN, key = "category.getCategoryCacheKey()", beforeInvocation = true)})
    public int delete(Category category) {
        System.out.println("Cache became invalid,value:" + CategoryCacheConstants.CATEGORY_DOMAIN
                + ",key:" + category.getCategoryCacheKey());
        return 0;
    }

    @Caching(put = {@CachePut(value = CategoryCacheConstants.CATEGORY_DOMAIN, key = "category.getCategoryCacheKey()")})
    public int update(Category category) {
        System.out.println("Cache updated,value:" + CategoryCacheConstants.CATEGORY_DOMAIN
                + ",key:" + category.getCategoryCacheKey()
                + ",category:" + category);
        return 1;
    }

    @Caching(cacheable = {@Cacheable(value = CategoryCacheConstants.CATEGORY_DOMAIN, key = "category.getCategoryCacheKey()")})
    public Category get(Category category) {
        Category result = new Category();
        result.setCateId(category.getCateId());
        result.setCateName(category.getCateId() + "CateName");
        result.setParentId(category.getCateId() - 10);
        return result;
    }
}
