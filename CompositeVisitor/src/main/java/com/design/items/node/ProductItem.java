package com.design.items.node;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProductItem extends AbstractProductItem{
    private Long id;
    private Long pid;
    private String name;
    private List<ProductItem> child = new ArrayList<>();

    @Override
    public void addItem(AbstractProductItem productItem) {
        this.child.add((ProductItem) productItem);
    }

    @Override
    public void delItem(AbstractProductItem productItem) {
        ProductItem item = (ProductItem) productItem;
        this.child = this.child.stream().filter(x -> x.getId() != item.getId()).collect(Collectors.toList());
    }
}
