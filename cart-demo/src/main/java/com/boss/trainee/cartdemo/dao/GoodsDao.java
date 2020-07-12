package com.boss.trainee.cartdemo.dao;

import com.boss.trainee.cartdemo.entity.Goods;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: Jianbinbing
 * @Date: 2020/7/12 20:31
 */
@Repository
public interface GoodsDao extends Mapper<Goods> {
}
