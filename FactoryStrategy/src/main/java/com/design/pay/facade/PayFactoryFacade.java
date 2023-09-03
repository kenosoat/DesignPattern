package com.design.pay.facade;

import com.design.pay.constant.PayType;
import com.design.pay.factory.PayStrategyFactory;
import com.design.pay.strategy.PayStrategy;
import com.design.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayFactoryFacade {

    @Autowired
    private PayStrategyFactory payStrategyFactory;

    // 门面类 对外提供统一的接口进行调用
    public Boolean pay(Order order)  {
        PayStrategy payStrategy = payStrategyFactory.getPayStrategy(order.getPayType());
        return payStrategy.pay(order);
    }
}
