package com.design.order.constant;

// 订单状态变化枚举; 作为状态变化的触发枚举
public enum OrderStatusChangeEvent {
    PAY_ORDER,
    SEND_ORDER,
    RECEIVE_ORDER;
}
