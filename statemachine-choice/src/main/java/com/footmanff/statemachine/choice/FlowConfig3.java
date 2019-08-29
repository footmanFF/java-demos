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
@EnableStateMachineFactory( name = "junction3" )
@WithStateMachine
public class FlowConfig3 extends StateMachineConfigurerAdapter<String, String> {

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
              .end("end")
              .states(stateSet);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions)
            throws Exception {
        transitions
                .withExternal()
                    .source("init")
                    .target("seq1")
                    .event("event")
                    .action((c) -> System.out.println("init => seq1")).and()
                .withExternal()
                    .source("seq1")
                    .target("seq2")
                    .action((c) -> System.out.println("seq1 => seq2")).and()
                .withExternal()
                    .source("seq2")
                    .target("seq3")
                    .action((c) -> System.out.println("seq2 => seq3")).and()
                .withExternal()
                    .source("seq3")
                    .target("end")
                    .action((c) -> System.out.println("seq3 => end"));
        ;
    }

}