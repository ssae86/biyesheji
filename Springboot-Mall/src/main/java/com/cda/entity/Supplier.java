package com.cda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description 供应商表
 */
@Data
@Entity
@Table(name = "supplier")
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    private Integer supplierId;
    private String supplierNo;
    private String supplierName;
    private String productType;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 联系方式
     */
    private String contactWay;

    /**
     * 是否可用
     */
    private Boolean status;
}
