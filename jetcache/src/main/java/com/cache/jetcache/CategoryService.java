package com.cache.jetcache;

import com.alicp.jetcache.anno.*;
import com.common.cache.constants.CategoryCacheConstants;
import com.common.cache.dto.Category;
import org.springframework.stereotype.Service;

/**
 * @author zhuzhenke
 * @date 2018/10/29
 */
@Service
public class CategoryService {

    @CacheInvalidate(name = CategoryCacheConstants.CATEGORY_DOMAIN,
            key = "#category.getCategoryCacheKey()")
    public int add(Category category) {
        System.out.println("模拟进行数据库交互操作......");
        System.out.println("Cache became invalid,value:" + CategoryCacheConstants.CATEGORY_DOMAIN
                + ",key:" + category.getCategoryCacheKey());
        return 1;
    }


    @CacheInvalidate(name = CategoryCacheConstants.CATEGORY_DOMAIN,
            key = "#category.getCategoryCacheKey()")
    public int delete(Category category) {
        System.out.println("模拟进行数据库交互操作......");
        System.out.println("Cache became invalid,value:" + CategoryCacheConstants.CATEGORY_DOMAIN
                + ",key:" + category.getCategoryCacheKey());
        return 0;
    }


    @CacheUpdate(name = CategoryCacheConstants.CATEGORY_DOMAIN,
            value = "#category",
            key = "#category.getCategoryCacheKey()")
    public int update(Category category) {
        System.out.println("模拟进行数据库交互操作......");
        System.out.println("Cache updated,value:" + CategoryCacheConstants.CATEGORY_DOMAIN
                + ",key:" + category.getCategoryCacheKey()
                + ",category:" + category);
        return 1;
    }


    @Cached(name = CategoryCacheConstants.CATEGORY_DOMAIN,
            expire = 3600,
            cacheType = CacheType.BOTH,
            key = "#category.getCategoryCacheKey()")
    public Category get(Category category) {
        System.out.println("模拟进行数据库交互操作......");
        Category result = new Category();
        result.setCateId(category.getCateId());
        result.setCateName(category.getCateId() + "JetCateName");
        result.setParentId(category.getCateId() - 10);
        return result;
    }
}
