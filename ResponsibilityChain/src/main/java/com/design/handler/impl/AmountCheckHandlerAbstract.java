package com.design.handler.impl;

import com.design.handler.AbstractSuggestAdvertHandler;
import com.design.pojo.UserInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AmountCheckHandlerAbstract extends AbstractSuggestAdvertHandler {

    // 金额检测
    @Override
    public Boolean process(UserInfo userInfo) {
        BigDecimal consumeAmount = userInfo.getConsumeAmount();
        // 上月消费 大于150 重度使用用户，进行广告投放
        if(consumeAmount.compareTo(BigDecimal.valueOf(100)) >= 0){
            return true;
        }
        return false;
    }
}
