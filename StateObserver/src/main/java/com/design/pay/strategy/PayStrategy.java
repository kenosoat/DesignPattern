package com.design.pay.strategy;

import com.design.pay.constant.PayType;
import com.design.pojo.Order;

public interface PayStrategy {

    boolean pay(Order order);

    PayType getPayType();
}
