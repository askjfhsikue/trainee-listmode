package com.boss.trainee.cartdemo.dao;

import com.boss.trainee.cartdemo.entity.Cart;
import com.boss.trainee.cartdemo.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 15:08
 */
@Repository
public interface CartDao extends Mapper<Cart> {

    @Select("select g.goods_id,g.goods_name,g.price,c.number from cart c inner join goods g " +
            "on c.goods_id=g.goods_id and user_id=#{userId}")
    List<Goods> getCartGoodsByUserId(@Param("userId") Long userId);


}
