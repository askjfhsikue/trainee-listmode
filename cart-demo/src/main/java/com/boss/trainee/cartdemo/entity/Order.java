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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long orderId;

    @Column
    private Long userId;

    @Column
    private Integer state;

    @Column
    private Long addressId;

    @Column
    private Date createTime;

    @Transient
    private HashMap<Long, OrderMessage> orderMessageHashMap;


}
