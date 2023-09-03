package com.design.service;

import com.design.pay.facade.PayFactoryFacede;
import com.design.pojo.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private PayFactoryFacede payFactoryFacede;


    public Boolean pay(Order order) {
        // 整个支付策略调用，使用了 单例工厂+ 门面接口 + 支付策略的方式，对外提供统一的接口，对内用极富拓展性
        // 甚至之后的 接口， 只需要我们去对  strategy策略类做增加和 constant 增加枚举策略
        // facade包下的 门面类，主要用于包装内部接口，对外提供统一一的接口
        // factory包下的 工厂类，通过支付策略枚举 生成策略类， 为了减少策略类的生成，又进行引入单例模式，进行优化，并且将相关的枚举策略映射 放入到策略类方法中。
        return payFactoryFacede.pay(order);
    }
}
