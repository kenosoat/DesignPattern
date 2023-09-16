package com.design.controller;

import com.design.items.node.ProductItem;
import com.design.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("get")
    public Object getItem(){
        return itemService.getItem();
    }

    @PostMapping("add")
    public Object addItem(@RequestBody ProductItem productItem){
        return itemService.addItem(productItem);
    }

    @PostMapping("del")
    public Object delItem(@RequestBody ProductItem productItem){
        return itemService.delItem(productItem);
    }
}
