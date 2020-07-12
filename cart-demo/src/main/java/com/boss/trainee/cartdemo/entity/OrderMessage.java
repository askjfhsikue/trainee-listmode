package com.boss.trainee.cartdemo.entity;

import lombok.Cleanup;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 14:43
 */
@Data
@Table(name = "order_message")
public class OrderMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column
    private Long orderId;

    @Column
    private Long goodsId;

    @Column
    private Integer number;

    @Column
    private BigDecimal goodsPrice;




}
