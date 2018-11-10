package com.footmanff.statemachine.choice;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author footmanff on 2018/10/24.
 */
@Configuration
@EnableStateMachineFactory( name = "junction1" )
@WithStateMachine
public class FlowConfig extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states)
            throws Exception {
        Set<String> stateSet = new HashSet<>();
        stateSet.add("init");
        stateSet.add("init2");

        stateSet.add("halfway1");
        stateSet.add("halfway2");

        stateSet.add("sec1");
        stateSet.add("sec2");
        stateSet.add("sec3");

        stateSet.add("end");

        states.withStates()
              .initial("init")
              .junction("init2")
              .junction("halfway1")
              .junction("halfway2")
              .end("end")
              .states(stateSet);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions)
            throws Exception {
        transitions.withJunction()
                   .source("init2")
                   .first("halfway1", (c) -> true, (c) -> System.out.println("init2 => halfway1"))
                   .last("halfway2", (c) -> System.out.println("init2 => halfway1"));
        
        transitions.withJunction()
                   .source("halfway1")
                   .first("sec1", (c) -> false, (c) -> System.out.println("halfway1 => sec1"))
                   .then("sec2", (c) -> false, (c) -> System.out.println("halfway1 => sec2"))
                   .last("sec3", (c) -> System.out.println("halfway1 => sec3"));

        transitions.withJunction()
                   .source("halfway2")
                   .first("sec1", (c) -> true, (c) -> System.out.println("halfway2 => sec1"))
                   .then("sec2", (c) -> true, (c) -> System.out.println("halfway2 => sec2"))
                   .last("sec3", (c) -> System.out.println("halfway2 => sec3"));

        transitions.withExternal()
                   .source("init")
                   .target("init2")
                   .event("init-init2");
    }

}