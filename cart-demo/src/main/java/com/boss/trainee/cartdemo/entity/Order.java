package com.boss.trainee.cartdemo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.HashMap;

/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 14:38
 */
@Data
@Table(name = "order_list")
public class Order {
    /**
     * 订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long orderId;
    /**
     * 用户id
     */
    @Column
    private Long userId;
    /**
     * 订单状态
     */
    @Column
    private Integer state;
    /**
     * 地址id
     */
    @Column
    private Long addressId;
    /**
     * 订单创建时间
     */
    @Column
    private Date createTime;
    /**
     * 订单详细信息
     */
    @Transient
    private HashMap<Long, OrderMessage> orderMessageHashMap;


}
