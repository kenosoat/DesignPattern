package com.design.service;

import com.design.pojo.UserInfo;
import com.design.process.AdvertSuggestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertService {

    @Autowired
    private AdvertSuggestProcessor advertSuggestProcessor;

    public Boolean showAdvert(UserInfo userInfo) {
        // 通过process进行责任器链条的判断，并且相关的责任链，当有一个责任链不满足的就拒绝投放广告
        // 后续着用去修改 handler中的类,就可以进行投放策略的增加和删除，拓展性很强，适合关联性不强但是校验链条很长的业务
        // 通过这种方式把需要经常改动的 if else 业务判断给拆解出来；
        return advertSuggestProcessor.process(userInfo);
    }
}
