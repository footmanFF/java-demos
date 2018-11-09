package com.footmanff.flow;

import com.gegejia.flow.manager.DefaultFlowEngine;
import com.gegejia.flow.manager.FlowEngine;
import com.gegejia.flow.support.FlowException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author footmanff on 2018/10/22.
 */
public class Main {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath*:application.xml");
        FlowEngine flowEngine = context.getBean(DefaultFlowEngine.class);
        try {
            flowEngine.execute("flowName", 1);
        } catch (FlowException e) {
            e.printStackTrace();
        }
    }
    
}
