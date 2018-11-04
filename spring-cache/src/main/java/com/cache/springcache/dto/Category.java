package com.cache.springcache.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhuzhenke
 * @date 2018/10/29
 */
@Data
public class Category implements Serializable {

    private static final long serialVersionUID = 8978267668479058032L;

    private Long cateId;
    private String cateName;
    private Long parentId;

    public Category() {
    }

    public Category(Long cateId, String cateName, Long parentId) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.parentId = parentId;
    }

    public String getCategoryCacheKey() {
        return String.valueOf(cateId);
    }
}
