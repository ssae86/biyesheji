package com.cda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cda
 * @create 2022-05-09 13:05
 * ES存储数据专用结构
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product4ES {
    private Integer productId;
    private String productName;
    private String productDescribe;
    private Double outPrice;
    private String productUrl;
}
