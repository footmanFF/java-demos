package com.footmanff.statemachine.choice;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.access.StateMachineAccess;
import org.springframework.statemachine.access.StateMachineFunction;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author footmanff on 2018/10/25.
 */
@Service
public class FlowService {

    @Resource( name = "junction1" )
    private StateMachineFactory<String, String> factory;

    @Resource( name = "junction2" )
    private StateMachineFactory<String, String> factory2;

    @Resource( name = "junction3" )
    private StateMachineFactory<String, String> factory3;

    public void test() {
        StateMachine machine = factory.getStateMachine();
        machine.start();
        machine.sendEvent("init-init2");
        machine.stop();
    }

    public void test2() {
        StateMachine machine = factory2.getStateMachine();
        machine.start();
        machine.sendEvent("init-seq1");
        machine.stop();
    }

    public void test3() {
        StateMachine machine = factory3.getStateMachine();

        machine.getStateMachineAccessor().doWithAllRegions(new StateMachineFunction<StateMachineAccess>() {
            @Override
            public void apply(StateMachineAccess function) {
                StateMachineInterceptorAdapter stateMachineInterceptorAdapter = new StateMachineInterceptorAdapter() {
                    @Override
                    public Message preEvent(Message message, StateMachine stateMachine) {
                        System.out.println("preEvent");
                        return super.preEvent(message, stateMachine);
                    }

                    @Override
                    public void postStateChange(State state, Message message, Transition transition, StateMachine stateMachine) {
                        System.out.println("postStateChange: " + transition.getSource().getId() + " => " + transition.getTarget().getId());
                        super.postStateChange(state, message, transition, stateMachine);
                    }
                };

                function.addStateMachineInterceptor(stateMachineInterceptorAdapter);
            }
        });


        machine.start();
        machine.sendEvent("event");
        machine.stop();
    }

}
