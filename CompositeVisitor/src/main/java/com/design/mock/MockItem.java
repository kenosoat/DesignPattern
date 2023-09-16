package com.design.mock;

import com.design.items.node.ProductItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MockItem {
    public static ProductItem productItem= new ProductItem();
    static {
        productItem.setPid(0L);
        productItem.setId(0L);
        productItem.setName("书籍");
        ArrayList<ProductItem> productItems = new ArrayList<>();
        for(int i = 1; i <= 3; i++){
            ProductItem productItem= new ProductItem();
            productItem.setPid(0L);
            productItem.setId((long) i);
            productItem.setName("Java"+i);
            productItems.add(productItem);
        }
        productItem.setChild(productItems);

    }
}
