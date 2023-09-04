package com.design.handler.impl;

import com.design.handler.AbstractSuggestAdvertHandler;
import com.design.pojo.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class WeekCloseCheckHandlerAbstract extends AbstractSuggestAdvertHandler {
    @Override
    public Boolean process(UserInfo userInfo) {
        Long weekCloseCount = userInfo.getWeekCloseCount();
        if(weekCloseCount < 60){
            return true;
        }
        return false;
    }
}
