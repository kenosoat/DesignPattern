package com.design.process;

import com.design.handler.AbstractSuggestAdvertHandler;
import com.design.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdvertSuggestProcessor {
    @Autowired
    private List<AbstractSuggestAdvertHandler> abstractSuggestAdvertHandlerList;


    public Boolean process(UserInfo userInfo) {
        for(AbstractSuggestAdvertHandler abstractSuggestAdvertHandler : abstractSuggestAdvertHandlerList){
            if (!abstractSuggestAdvertHandler.process(userInfo)) {
                return false;
            }
        }
        return true;
    }
}
