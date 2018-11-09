package com.footmanff.statemachine.refund;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author footmanff on 2018/10/24.
 */
public class RefundTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        Engine engine = (Engine) ctx.getBean("engine");

        Integer flowType = 1; // 一种流程
        PersistStateMachineHandler handler = engine.getHandler(flowType, "abc");
        
        String refund = "一个refund对象";
        boolean accept = handler.handleEventWithState(
                MessageBuilder
                        .withPayload("商家审核通过")
                        .setHeader("key", refund)
                        .build(),
                "待商家确认"
        );

        System.out.println("accept " + accept);
        
    }

}
