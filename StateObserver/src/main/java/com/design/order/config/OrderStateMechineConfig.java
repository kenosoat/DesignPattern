package com.design.order.config;


import com.design.order.constant.OrderStatusChangeEvent;
import com.design.order.constant.OrderState;
import com.design.pojo.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;


// spring 状态机的引入：进行状态的初始化，进行状态转化的管理，状态的持久化
@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMechineConfig extends StateMachineConfigurerAdapter<OrderState, OrderStatusChangeEvent> {

    // 状态机初始化配置
    public void configure(StateMachineStateConfigurer<OrderState, OrderStatusChangeEvent> states) throws Exception {
        // 状态机初始化和 定义所有枚举状态
        states.withStates().initial(OrderState.ORDER_WAIT_PAY).states(EnumSet.allOf(OrderState.class));
    }
    // 状态转化配置
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderStatusChangeEvent> transitions) throws Exception {
        transitions.withExternal().source(OrderState.ORDER_WAIT_PAY)
                .target(OrderState.ORDER_WAIT_SEND)
                .event(OrderStatusChangeEvent.PAY_ORDER);
        transitions.withExternal().source(OrderState.ORDER_WAIT_SEND)
                .target(OrderState.ORDER_WAIT_RECEIVE)
                .event(OrderStatusChangeEvent.SEND_ORDER);
        transitions.withExternal().source(OrderState.ORDER_WAIT_RECEIVE)
                .target(OrderState.ORDER_FINISH)
                .event(OrderStatusChangeEvent.RECEIVE_ORDER);
    }

    // 状态持久化
    @Bean
    public DefaultStateMachinePersister machinePersister(){
        return new DefaultStateMachinePersister<>(new StateMachinePersist<Object,Object, Order>(){
            @Override
            public void write(StateMachineContext<Object, Object> stateMachineContext, Order order) throws Exception {

            }

            // 使用持久化之后，需要配置相应的上下文，并指定相应的 读取事件，不然无法进行消息发送
            @Override
            public StateMachineContext<Object, Object> read(Order order) throws Exception {
                return new DefaultStateMachineContext(order.getOrderState(), null, null, null);
            }
        });
    }

}
