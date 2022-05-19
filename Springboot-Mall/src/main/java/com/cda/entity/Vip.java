package com.cda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description vip信息
 */
@Data
@Entity
@Table(name = "vip")
@NoArgsConstructor
@AllArgsConstructor
public class Vip {
    @Id
    private Integer vipId;
    private String accountNumber;
    private Date creatTime;
    private Date overdueTime;
}
