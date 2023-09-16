package com.design.items.visitor;

import com.design.items.node.ProductItem;

public interface ItemVisitor<T> {
    T visitor(ProductItem productItem);
}
