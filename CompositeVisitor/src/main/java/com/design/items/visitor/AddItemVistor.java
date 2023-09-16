package com.design.items.visitor;

import com.design.items.node.ProductItem;
import com.design.mock.MockItem;
import org.springframework.stereotype.Component;

@Component
public class AddItemVistor implements ItemVisitor<ProductItem> {
    @Override
    public ProductItem visitor(ProductItem productItem) {
        ProductItem currentItem = MockItem.productItem;
        if(currentItem.getId() == productItem.getId()){
            throw new UnsupportedOperationException("父节点不能删除");
        }
        if(currentItem.getId() == productItem.getPid()){
            currentItem.addItem(productItem);
            return currentItem;
        }
        addItem(currentItem,productItem);
        return currentItem;
    }

    private void addItem(ProductItem currentItem, ProductItem productItem) {
        for(ProductItem item:currentItem.getChild()){
            if(item.getId() == productItem.getPid()){
                item.addItem(productItem);
                break;
            }else{
                addItem(item,productItem);
            }
        }
    }
}
