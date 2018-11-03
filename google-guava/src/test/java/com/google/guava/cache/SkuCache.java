package com.google.guava.cache;

import lombok.Data;

/**
 * @author zhuzhenke
 * @date 2018/9/29
 */
@Data
public class SkuCache {
    private String skuId;
    private String skuCode;
    private Long realQuantity;
}
