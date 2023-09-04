package com.design.handler.impl;

import com.design.handler.AbstractSuggestAdvertHandler;
import com.design.pojo.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class NewUserCheckHandlerAbstract extends AbstractSuggestAdvertHandler {
    @Override
    public Boolean process(UserInfo userInfo) {
        // 一般要根据用户创建时间判断
        boolean infoNewUser = userInfo.isNewUser();
        return !infoNewUser;
    }
}
