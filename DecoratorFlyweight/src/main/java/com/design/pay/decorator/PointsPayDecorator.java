package com.design.pay.decorator;

import com.design.pay.strategy.PayStrategy;
import com.design.pojo.Order;

public class PointsPayDecorator extends AbstractPayDecorator{
    public PointsPayDecorator(PayStrategy payStrategy) {
        super(payStrategy);
    }

    @Override
    public boolean pay(Order order) {
        super.pay(order);
        addPoint(order);
        return true;
    }

    // 用户支付，积分增加
    public boolean addPoint(Order order){
        String accountNo = order.getAccountNo();
        //获取用户账号， 给用户添加积分
        System.out.println("用户积分添加");
        return true;
    }
}
