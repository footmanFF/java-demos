//package com.footmanff.statemachine.refund;
//
//import com.footmanff.statemachine.Events;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.statemachine.annotation.WithStateMachine;
//import org.springframework.statemachine.config.StateMachineFactory;
//import org.springframework.stereotype.Service;
//
///**
// * @author footmanff on 2018/10/24.
// */
//@Service
//@WithStateMachine
//public class SomeBean {
//
////    @Autowired
////    StateMachine<RefundStatus, RefundEvent> stateMachine;
//
//    @Autowired
//    StateMachineFactory<RefundStatus, RefundEvent> factory;
//
//    public void doSignals() {
//        StateMachine<RefundStatus, RefundEvent> stateMachine = factory.getStateMachine("123_id");
//        
//        stateMachine.start();
//        boolean accepted = stateMachine.sendEvent(RefundEvent.商家审核通过);
//        System.out.println("商家审核通过 " + (accepted ? "接受" : "拒绝"));
//        accepted = stateMachine.sendEvent(RefundEvent.商家审核拒绝);
//        System.out.println("商家审核拒绝 " + (accepted ? "接受" : "拒绝"));
//    }
//
//}
