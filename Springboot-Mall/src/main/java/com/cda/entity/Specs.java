package com.cda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @description 商品规格表   eg：服装 M、X、XL尺码等信息
 */

@Data
@Entity
@Table(name = "specs")
@NoArgsConstructor
@AllArgsConstructor
public class Specs implements Serializable {
    @Id
    private Integer specsId;
    private String specsName;
    private String productType;
}
