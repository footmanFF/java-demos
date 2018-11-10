package com.footmanff.statemachine.choice;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
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

}
