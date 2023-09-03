package com.design.pojo;

import com.design.order.constant.OrderState;
import com.design.pay.constant.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;

    private String accountNo;

    private String OrderNo;

    private PayType payType;

    private OrderState orderState;

    private BigDecimal price;

}
