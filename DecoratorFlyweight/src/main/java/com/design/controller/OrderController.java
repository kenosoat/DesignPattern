package com.design.controller;


import com.design.pojo.Order;
import com.design.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("create")
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }


    @RequestMapping("pay")
    public Order pay(@RequestBody Order order){
        return orderService.pay(order);
    }

    @RequestMapping("send")
    public Order send(int id){
        return orderService.send(id);
    }

    @RequestMapping("receive")
    public Order receive(int id){
        return orderService.receive(id);
    }

}
