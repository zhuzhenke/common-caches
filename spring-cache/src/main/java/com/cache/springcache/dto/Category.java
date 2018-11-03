package com.cache.springcache.dto;

import lombok.Data;

/**
 * @author zhuzhenke
 * @date 2018/10/29
 */
@Data
public class Category {
    private Long cateId;
    private String cateName;
    private Long parentId;


    public String getCategoryCacheKey(){
        return String.valueOf(cateId);
    }
}
