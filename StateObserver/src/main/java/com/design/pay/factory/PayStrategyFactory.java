package com.design.pay.factory;

import com.design.pay.constant.PayType;
import com.design.pay.strategy.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Component
public class PayStrategyFactory {

    @Autowired
    private List<PayStrategy> payStrategies;

    // 单例工厂， 通过枚举映射 每个 支付策略
    private final static HashMap<PayType, PayStrategy> payStrategyMap = new HashMap<>();

    @PostConstruct
    private void init(){
        for (PayStrategy payStrategy: payStrategies){
            payStrategyMap.put(payStrategy.getPayType(),payStrategy);
        }
    }

    public PayStrategy getPayStrategy(PayType payType){
        PayStrategy payStrategy = payStrategyMap.get(payType);
        try {
            if(payStrategy == null){
                throw new Exception("没有该支付策略");
            }
        }catch (Exception e){

        }
        return payStrategy;
    }

}
