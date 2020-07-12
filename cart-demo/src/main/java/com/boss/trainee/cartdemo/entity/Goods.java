package com.boss.trainee.cartdemo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 14:24
 */

@Data
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goodsId;

    @Column
    private String goodsName;

    @Column
    private BigDecimal price;

    @Transient
    private Integer number;

}
