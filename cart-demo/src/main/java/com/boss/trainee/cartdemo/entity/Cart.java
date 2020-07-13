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
    /**
     * 购物车id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    /**
     * 用户id
     */
    @Column
    private Long userId;
    /**
     * 商品id
     */
    @Column
    private Long goodsId;
    /**
     * 购买数量
     */
    @Column
    private Integer number;


}
