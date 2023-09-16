package com.design.service;

import com.design.items.node.ProductItem;
import com.design.items.visitor.AddItemVistor;
import com.design.items.visitor.DelItemVisitor;
import com.design.mock.MockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    public AddItemVistor addItemVistor;

    @Autowired
    public DelItemVisitor delItemVisitor;

    public Object getItem() {
        return MockItem.productItem;
    }

    public Object addItem(ProductItem productItem) {
        return addItemVistor.visitor(productItem);
    }

    public Object delItem(ProductItem productItem) {
        return delItemVisitor.visitor(productItem);
    }
}
