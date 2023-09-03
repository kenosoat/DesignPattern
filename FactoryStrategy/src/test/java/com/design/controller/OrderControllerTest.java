package com.design.controller;


import com.design.FSApplication;
import com.design.pay.constant.PayType;
import com.design.pojo.Order;
import com.design.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FSApplication.class)
class OrderControllerTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test(){
        Order order = new Order();
        order.setPayType(PayType.WxPay);
        order.setPayType(PayType.AliPay);
        order.setPayType(PayType.UnionPay);
        orderService.pay(order);
    }
}