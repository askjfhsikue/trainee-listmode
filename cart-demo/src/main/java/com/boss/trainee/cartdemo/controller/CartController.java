package com.boss.trainee.cartdemo.controller;

import com.boss.trainee.cartdemo.entity.Cart;
import com.boss.trainee.cartdemo.entity.Goods;
import com.boss.trainee.cartdemo.service.CartService;
import com.boss.trainee.cartdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 16:42
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/getCart")
    @ResponseBody
    public Object getCart() {
        List<Goods> goods = cartService.getCart(234L);
        return goods;
    }

    @PostMapping("/add")
    @ResponseBody
    public Object addGoods(@RequestBody Cart cart) {
        return cartService.insert(cart);
    }

    @GetMapping("/remove")
    @ResponseBody
    public Object remove(Long userId, Long goodsId) {
        return cartService.remove(userId, goodsId);
    }

    @PostMapping("/update")
    @ResponseBody
    public Object update(@RequestBody Cart cart) {
        return cartService.update(cart);
    }

    @PostMapping("/getTotalPrice")
    @ResponseBody
    public Object getPrice(@RequestBody List<Long> goodsIds) {
        return cartService.getPrice(goodsIds);
    }

    @PostMapping("/addOrder")
    @ResponseBody
    public Object addOrder(@RequestBody HashMap<Long, Integer> goodsMsg) {
        Long userId = 234L;
        Long addressId = 1L;
        Integer state = 2;
        orderService.insert(userId, addressId, state, goodsMsg);
        return true;
    }

}
