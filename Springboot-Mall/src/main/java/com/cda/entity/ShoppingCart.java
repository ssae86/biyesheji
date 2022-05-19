package com.cda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description 购物车实体类
 */

@Data
@Entity
@Table(name = "shopping_cart")
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    @Id
    private Integer cartId;
    private String accountNumber;
    private Integer productId;
    private Integer payAmount;
    private String productSpecs;
}
