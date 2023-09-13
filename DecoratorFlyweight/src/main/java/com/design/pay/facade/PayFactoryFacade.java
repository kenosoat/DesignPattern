package com.design.pay.facade;

import com.design.pay.decorator.AbstractPayDecorator;
import com.design.pay.factory.PayStrategyFactory;
import com.design.pay.factory.PointsPayFactory;
import com.design.pay.strategy.PayStrategy;
import com.design.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayFactoryFacade {

    @Autowired
    private PayStrategyFactory payStrategyFactory;

    @Autowired
    private PointsPayFactory pointsPayFactory;
    // 门面类 对外提供统一的接口进行调用
    public Boolean pay(Order order)  {
        PayStrategy payStrategy = payStrategyFactory.getPayStrategy(order.getPayType());
        // 通过装饰者模式，进行用户支付  积分添加，或者发放红包; 由于门面模式的存在，用户对支付接口的功能添加无感知，相应的业务代码也没有新增
        // 因此，装饰者模式，可以对一些功能拓展做一些新增
        // 由于new 对象，在支付接口这种被频繁调用，高并发下的接口，new对象会导致 young gc的产生
        // 需要对 new 进行优化，因此采用享元模式，即单例复用实现，通过映射关系，存放相应的类；即单例工厂，也就是享元模式
        // spring ioc 单例模式也是采用map存储单例对象 复用
//        AbstractPayDecorator abstractPayDecorator = new PointsPayDecorator(payStrategy);
        AbstractPayDecorator abstractPayDecorator = pointsPayFactory.getPointsPayDecorator(payStrategy);
        return abstractPayDecorator.pay(order);
    }
}
