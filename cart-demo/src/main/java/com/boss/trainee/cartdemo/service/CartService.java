package com.boss.trainee.cartdemo.service;

import com.boss.trainee.cartdemo.dao.CartDao;
import com.boss.trainee.cartdemo.dao.GoodsDao;
import com.boss.trainee.cartdemo.entity.Cart;
import com.boss.trainee.cartdemo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Jianbinbing
 * @Date: 2020/7/9 15:04
 */
@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private GoodsDao goodsDao;

    private HashMap<Long, Goods> myCartGoods = new HashMap<>();


    /**
     * 检验参数是否合法
     *
     * @param cart 购物车对象
     * @return boolean
     */
    private boolean checkout(Cart cart) {
        Long userId = cart.getUserId();
        Long goodsId = cart.getGoodsId();
        Integer num = cart.getNumber();
        if (userId == null || goodsId == null || num == null) {
            throw new IllegalArgumentException("参数为空");
        }
        return true;
    }

    /**
     * 通过用户id和商品id获取单条购物车信息并返回
     *
     * @param cart 购物车对象
     * @return cart 购物车对象
     */
    private Cart getOne(Cart cart) {
        Example example = new Example(Cart.class);
        example.createCriteria()
                .andEqualTo("userId", cart.getUserId())
                .andEqualTo("goodsId", cart.getGoodsId());

        return cartDao.selectOneByExample(example);
    }

    /**
     * 更新购物车公共方法
     *
     * @param cart 购物车对象
     * @return Boolean
     */
    private Boolean updateCart(Cart cart) {

        checkout(cart);
        Example example = new Example(Cart.class);
        example.createCriteria()
                .andEqualTo("userId", cart.getUserId())
                .andEqualTo("goodsId", cart.getGoodsId());
        Cart cart1 = new Cart();
        cart1.setNumber(cart.getNumber());
        cartDao.updateByExampleSelective(cart1, example);

        return true;
    }

    /**
     * 返回购物车信息
     *
     * @param userId 用户id
     * @return list 商品列表
     */
    private List<Goods> setMyCartGoods(Long userId) {
        List<Goods> myCart = new ArrayList<>();
        if (userId == null) {
            return myCart;
        }
        myCart = cartDao.getCartGoodsByUserId(userId);
        for (Goods goods :
                myCart) {
            myCartGoods.put(goods.getGoodsId(), goods);
        }
        return myCart;
    }

    /**
     * 通过用户id在数据库中获取用户购物车中的商品信息并返回
     *
     * @param userId 用户id
     * @return list 商品列表
     */
    public List<Goods> getCart(Long userId) {

        return setMyCartGoods(userId);
    }


    /**
     * 获取选择的商品总价
     *
     * @param ids 商品id
     * @return BigDecimal 总价
     */
    public BigDecimal getPrice(List<Long> ids) {
        setMyCartGoods(234L);
        BigDecimal totalPrice = new BigDecimal(0);
        for (Long id :
                ids) {
            Goods goods = myCartGoods.get(id);
            totalPrice = totalPrice.add(goods.getPrice().multiply(BigDecimal.valueOf(goods.getNumber())));
        }

        return totalPrice;
    }


    /**
     * 向购物车中添加商品
     * 若原购物车中不存在该商品id，则直接将该商品添加进购物车中
     * 否则让原购物车中商品数量被参数中的商品数量覆盖。
     *
     * @param cart 购物车对象
     * @return cart 购物车对象
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean insert(Cart cart) {
        checkout(cart);
        Cart temp = getOne(cart);
        if (temp == null) {
            cartDao.insert(cart);
            Goods goods = goodsDao.selectByPrimaryKey(cart.getGoodsId());
            goods.setNumber(cart.getNumber());

            return true;
        }
        Integer number = cart.getNumber();
        cart.setNumber(number);
        updateCart(cart);

        return true;

    }

    /**
     * 删除购物车中商品
     *
     * @param userId  用户id
     * @param goodsId 商品id
     * @return Boolean
     */
    public Boolean remove(Long userId, Long goodsId) {
        if (userId == null || goodsId == null) {
            throw new IllegalArgumentException("参数为空");
        }
        Cart cart = new Cart();
        cart.setGoodsId(goodsId);
        cart.setUserId(userId);
        if (getOne(cart) != null) {
            cartDao.delete(cart);
            return true;
        } else {
            throw new IllegalArgumentException("未在购物车中找到该商品");
        }


    }

    /**
     * 更新购物车中选购商品数量
     *
     * @param cart 购物车对象
     * @return Boolean
     */
    public Boolean update(Cart cart) {

        return updateCart(cart);
    }


}
