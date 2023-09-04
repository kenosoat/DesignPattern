package com.design.controller;

import com.design.pojo.UserInfo;
import com.design.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("advert")
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    @RequestMapping("/showAdvert")
    public Boolean show(@RequestBody UserInfo userInfo){
        return advertService.showAdvert(userInfo);
    }
}
