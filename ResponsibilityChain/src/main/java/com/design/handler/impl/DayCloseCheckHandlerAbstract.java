package com.design.handler.impl;

import com.design.handler.AbstractSuggestAdvertHandler;
import com.design.pojo.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class DayCloseCheckHandlerAbstract extends AbstractSuggestAdvertHandler {
    @Override
    public Boolean process(UserInfo userInfo) {
        Long dayCloseCount = userInfo.getDayCloseCount();
        // 一天关闭次数 小于 10  一般要根据配置类匹配
        if(dayCloseCount < 10){
            return true;
        }
        return false;
    }
}
