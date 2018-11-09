package com.footmanff.statemachine.refund;

import org.springframework.messaging.Message;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.EventHeaders;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

import java.util.Map;

/**
 * @author footmanff on 2018/10/25.
 */
//@WithStateMachine(id = "abc", name = "abc")
@WithStateMachine
public class TransitionConfig {

    /**
     * {@link ExtendedState}, {@link Map} if map argument itself is annotated
     * with {@link EventHeaders}, {@link StateMachine}, {@link Message} or {@link Exception}.
     */
//    @OnTransition(source = "待商家确认", target = "通过")
    @OnTransition(target = "通过")
    public void aaaa(
//            @EventHeaders Map<String, Object> headers,
//            ExtendedState extendedState,
//            StateMachine<String, String> stateMachine,
//            Message<String> message,
//            Exception e
    ) {
        System.out.println("TransitionConfig sellerConfirm");
    }

}