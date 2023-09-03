package com.design.service;

import com.design.order.constant.OrderStatusChangeEvent;
import com.design.order.constant.OrderState;
import com.design.pay.facade.PayFactoryFacade;
import com.design.pojo.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    @Resource
    private PayFactoryFacade payFactoryFacade;

    private Map<Integer, Order> orders = new HashMap<>();

    @Resource
    private StateMachine<OrderState, OrderStatusChangeEvent> orderStateMachine;

    @Resource
    private StateMachinePersister<OrderState, OrderStatusChangeEvent,Order> stateMachinePersister;


    public Order pay(Order order) {
        // 整个支付策略调用，使用了 单例工厂+ 门面接口 + 支付策略的方式，对外提供统一的接口，对内用极富拓展性
        // 甚至之后的 接口， 只需要我们去对  strategy策略类做增加和 constant 增加枚举策略
        // facade包下的 门面类，主要用于包装内部接口，对外提供统一一的接口
        // factory包下的 工厂类，通过支付策略枚举 生成策略类， 为了减少策略类的生成，又进行引入单例模式，进行优化，并且将相关的枚举策略映射 放入到策略类方法中。
        Boolean pay = payFactoryFacade.pay(order);

        order = orders.get(order.getId());
        if(pay){
            // 订单状态转化 消息创建
            // 状态机发送消息，并且持久化转化后的消息
            if (changeStateAction(OrderStatusChangeEvent.PAY_ORDER,order)) {
                return order;
            }
        }
        return order;
    }

    public Order create(Order order) {
        order.setOrderState(OrderState.ORDER_WAIT_PAY);
        orders.put(order.getId(),order);
        return order;
    }

    public Order send(int id) {
        Order order = orders.get(id);
        if (changeStateAction(OrderStatusChangeEvent.SEND_ORDER,order)) {
            return order;
        }
        return order;
    }

    public Order receive(Integer id) {
        Order order = orders.get(id);
        if (changeStateAction(OrderStatusChangeEvent.RECEIVE_ORDER,order)) {
            return order;
        }
        return order;
    }

    private boolean changeStateAction(OrderStatusChangeEvent event, Order order)  {
        Message<OrderStatusChangeEvent> message = MessageBuilder.withPayload(event)
                .setHeader("order", order).build();
        boolean result = false;
        try {
            orderStateMachine.start();
            stateMachinePersister.restore(orderStateMachine,order);
            result = orderStateMachine.sendEvent(message);
            stateMachinePersister.persist(orderStateMachine,order);
            return result;
        }catch (Exception e){

        }finally {
            orderStateMachine.stop();
        }
        return result;

    }
}
