package com.footmanff.statemachine.choice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author footmanff on 2018/10/24.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        FlowService engine = (FlowService) ctx.getBean("flowService");

        engine.test();
    }

}
