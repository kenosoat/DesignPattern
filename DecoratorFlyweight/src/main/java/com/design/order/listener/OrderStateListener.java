package com.design.order.listener;

import com.design.order.constant.OrderState;
import com.design.order.constant.OrderStatusChangeEvent;
import com.design.pojo.Order;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

@Component("orderStateListener")
// 监听器要和状态机进行绑定
@WithStateMachine(name = "orderStateMachine")
public class OrderStateListener {

    // 获取到事件之后，可以在监听器进行落库，实现状态变化的解耦

    // 通过注解绑定 相应的状态变化; 接受状态转化触发枚举类的消息
    @OnTransition(source = "ORDER_WAIT_PAY",target = "ORDER_WAIT_SEND")
    public boolean payToSend(Message<OrderStatusChangeEvent> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.ORDER_WAIT_SEND);
        System.out.println("ORDER_WAIT_PAY"+order);
        return true;
    }

    @OnTransition(source = "ORDER_WAIT_SEND",target = "ORDER_WAIT_RECEIVE")
    public boolean sendToReceive(Message<OrderStatusChangeEvent> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.ORDER_WAIT_RECEIVE);
        System.out.println("ORDER_WAIT_SEND"+order);
        return true;
    }

    @OnTransition(source = "ORDER_WAIT_RECEIVE",target = "ORDER_FINISH")
    public boolean receiveToFinish(Message<OrderStatusChangeEvent> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.ORDER_FINISH);
        System.out.println("ORDER_WAIT_RECEIVE"+order);
        return true;
    }
}
