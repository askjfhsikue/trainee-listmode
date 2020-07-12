package com.boss.trainee.cartdemo.dao;

import com.boss.trainee.cartdemo.entity.OrderMessage;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 15:03
 */
@Repository
public interface OrderMessageDao extends Mapper<OrderMessage> {
}
