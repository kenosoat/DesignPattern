package com.design.pay.factory;

import com.design.pay.decorator.PointsPayDecorator;
import com.design.pay.strategy.PayStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PointsPayFactory {

    public static final Map<PayStrategy, PointsPayDecorator> map = new ConcurrentHashMap<>();

    public PointsPayDecorator getPointsPayDecorator(PayStrategy payStrategy){
        PointsPayDecorator pointsPayDecorator = map.get(payStrategy);
        if(pointsPayDecorator == null){
            pointsPayDecorator = new PointsPayDecorator(payStrategy);
            map.put(payStrategy,pointsPayDecorator);
        }
        return pointsPayDecorator;
    }
}
