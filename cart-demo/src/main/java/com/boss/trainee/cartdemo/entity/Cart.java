package com.boss.trainee.cartdemo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 15:09
 */
@Data
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column
    private Long userId;

    @Column
    private Long goodsId;

    @Column
    private Integer number;


}
