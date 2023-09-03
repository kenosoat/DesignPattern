package com.design.order.constant;

import lombok.Data;
import lombok.Getter;
// 订单状态枚举
public enum OrderState {
    ORDER_WAIT_PAY,
    ORDER_WAIT_SEND,
    ORDER_WAIT_RECEIVE,
    ORDER_FINISH;
}
