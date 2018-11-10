package com.footmanff.statemachine.choice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;

/**
 * @author footmanff on 2018/10/25.
 */
@Service
public class FlowService {

    @Autowired
    private StateMachineFactory<String, String> factory;

    public void test() {
        StateMachine machine = factory.getStateMachine();
        machine.start();
        machine.sendEvent("init-init2");
        machine.stop();
    }

}
