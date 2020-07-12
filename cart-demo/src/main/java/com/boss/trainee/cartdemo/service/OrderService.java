package com.boss.trainee.cartdemo.service;


import com.boss.trainee.cartdemo.dao.GoodsDao;
import com.boss.trainee.cartdemo.dao.OrderDao;
import com.boss.trainee.cartdemo.dao.OrderMessageDao;
import com.boss.trainee.cartdemo.entity.Goods;
import com.boss.trainee.cartdemo.entity.Order;
import com.boss.trainee.cartdemo.entity.OrderMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 15:00
 */
@Service
public class OrderService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderMessageDao orderMessageDao;


    /**
     * 从购物车页面下单
     * 首先将信息插入订单列表中，然后获取生成的订单id在订单详情表中插入数据，
     * 最后删除购物车中成功下单的数据。
     *
     * @param userId
     * @param addressId
     * @param state
     * @param goodsMsg
     */
    @Transactional(rollbackFor = Exception.class)
    public void insert(Long userId, Long addressId, Integer state,
                       HashMap<Long, Integer> goodsMsg) {
        Order order = new Order();
        Date date = new Date();
        order.setUserId(userId);
        order.setAddressId(addressId);
        order.setCreateTime(date);
        order.setState(state);
        orderDao.insert(order);
        HashMap<Long, Goods> orderMsg = getMsg(goodsMsg);
        List<OrderMessage> orderMessages = new LinkedList<>();
        for (Map.Entry<Long, Goods> entry : orderMsg.entrySet()) {
            OrderMessage orderMessage = new OrderMessage();
            orderMessage.setOrderId(order.getOrderId());
            orderMessage.setGoodsId(entry.getKey());
            orderMessage.setNumber(entry.getValue().getNumber());
            orderMessage.setGoodsPrice(entry.getValue().getPrice());
            orderMessages.add(orderMessage);
            orderMessageDao.insert(orderMessage);
            cartService.remove(userId, entry.getKey());
        }

    }

    private HashMap<Long, Goods> getMsg(HashMap<Long, Integer> goodsMsg) {
        HashMap<Long, Goods> orderMsg = new HashMap<>();

        for (Map.Entry<Long, Integer> entry : goodsMsg.entrySet()) {
            Goods goods = goodsDao.selectByPrimaryKey(entry.getKey());
            goods.setNumber(entry.getValue());
            orderMsg.put(goods.getGoodsId(), goods);
        }

        return orderMsg;
    }


}
