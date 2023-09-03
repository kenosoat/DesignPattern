package com.design.pay.strategy.impl;

import com.design.pay.constant.PayType;
import com.design.pay.strategy.PayStrategy;
import com.design.pojo.Order;
import org.springframework.stereotype.Service;

@Service
public class WxPayStrategy implements PayStrategy {
    @Override
    public boolean pay(Order order) {
        System.out.println("微信支付");
        return true;
    }

    @Override
    public PayType getPayType() {
        return PayType.WxPay;
    }
}
