package com.design.pay.decorator;

import com.design.pay.constant.PayType;
import com.design.pay.strategy.PayStrategy;
import com.design.pojo.Order;

public abstract class AbstractPayDecorator implements PayStrategy {
    private PayStrategy payStrategy;

    @Override
    public PayType getPayType() {
        return payStrategy.getPayType();
    }

    public AbstractPayDecorator(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    @Override
    public boolean pay(Order order) {
        return payStrategy.pay(order);
    }
}
