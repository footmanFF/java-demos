package com.footmanff.statemachine.refund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.stereotype.Service;

/**
 * @author footmanff on 2018/10/25.
 */
@Service
public class Engine {

    @Autowired
    private StateMachineFactory<String, String> factory;

    private LocalPersistStateChangeListener listener = new LocalPersistStateChangeListener();

    public PersistStateMachineHandler getHandler(Integer flowType, String id) {
        StateMachine<String, String> stateMachine = factory.getStateMachine(id);

        stateMachine.addStateListener(new StateMachineListenerAdapter<>());
        
        PersistStateMachineHandler persistStateMachineHandler = new PersistStateMachineHandler(stateMachine);
        persistStateMachineHandler.addPersistStateChangeListener(listener);
        persistStateMachineHandler.init();
        return persistStateMachineHandler;
    }

}
