package com.boss.trainee.cartdemo.entity;

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
    /**
     * 订单详细信息id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    /**
     * 订单id
     */
    @Column
    private Long orderId;
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
    /**
     * 商品价格
     */
    @Column
    private BigDecimal goodsPrice;


}
