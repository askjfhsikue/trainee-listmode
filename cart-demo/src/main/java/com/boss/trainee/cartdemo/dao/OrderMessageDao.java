package com.boss.trainee.cartdemo.dao;

import com.boss.trainee.cartdemo.entity.OrderMessage;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 15:03
 */
@Repository
public interface OrderMessageDao extends Mapper<OrderMessage>, InsertListMapper<OrderMessage> {

}
