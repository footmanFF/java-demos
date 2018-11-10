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
@EnableStateMachineFactory( name = "junction2" )
@WithStateMachine
public class FlowConfig2 extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states)
            throws Exception {
        Set<String> stateSet = new HashSet<>();
        stateSet.add("init");
        stateSet.add("seq1");
        stateSet.add("seq2");
        stateSet.add("seq3");

        stateSet.add("end");

        states.withStates()
              .initial("init")
              .junction("seq1")
              .junction("seq2")
              .end("end")
              .states(stateSet);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions)
            throws Exception {
        transitions.withJunction()
                   .source("seq1")
                   .last("seq2", (c) -> System.out.println("seq1 => seq2"));

        transitions.withJunction()
                   .source("seq2")
                   .last("seq3", (c) -> System.out.println("seq2 => seq3"));

        transitions.withExternal()
                   .source("init")
                   .target("seq1")
                   .event("init-seq1");
    }

}