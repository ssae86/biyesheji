package com.cda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @description 商品分类 实体
 */
@Data
@Entity
@Table(name = "product_type")
@NoArgsConstructor
@AllArgsConstructor
public class ProductType implements Serializable {
    @Id
    private Integer typeId;
    private String typeName;
    private String typeDescribe;
    private String typeUrlLeft;
    private String typeUrlTop;
}
