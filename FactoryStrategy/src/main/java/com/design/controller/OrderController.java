package com.design.controller;


import com.design.pojo.Order;
import com.design.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("pay")
    public Boolean pay(Order order){
        return orderService.pay(order);
    }
}
