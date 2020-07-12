package com.boss.trainee.cartdemo.dao;

import com.boss.trainee.cartdemo.entity.Order;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 14:59
 */
@Repository
public interface OrderDao extends Mapper<Order> {
}
