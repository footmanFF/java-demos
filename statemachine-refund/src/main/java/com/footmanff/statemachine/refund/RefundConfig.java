package com.footmanff.statemachine.refund;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author footmanff on 2018/10/24.
 */
@Configuration
@EnableStateMachineFactory
@WithStateMachine
public class RefundConfig extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states)
            throws Exception {
        Set<String> stateSet = new HashSet<>();
        stateSet.add("待商家确认");
        stateSet.add("通过");
        stateSet.add("拒绝");
        states.withStates()
              .initial("待商家确认")
              .states(stateSet);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions)
            throws Exception {
        transitions.withExternal()
                   .source("待商家确认").target("拒绝").event("商家审核拒绝")
                   .action(sellerRefuse())
                   .and()
                   .withExternal()
                   .source("待商家确认").target("通过").event("商家审核通过")
                   .action(sellerConfirm())
        ;
    }

    @Bean
    public Action<String, String> sellerConfirm() {
        return new Action<String, String>() {
            @Override
            public void execute(StateContext<String, String> context) {
                context.getExtendedState().getVariables().put("一个回调函数", new Consumer<String>() {
                    @Override
                    public void accept(String o) {
                        System.out.println("执行回调函数");
                    }
                });
                System.out.println("sellerConfirm");
            }
        };
    }

    @Bean
    public Action<String, String> sellerRefuse() {
        return new Action<String, String>() {
            @Override
            public void execute(StateContext<String, String> context) {
                System.out.println("sellerRefuse");
            }
        };
    }

}