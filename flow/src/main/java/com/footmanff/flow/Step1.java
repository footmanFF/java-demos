package com.footmanff.flow;

import com.gegejia.flow.execution.FlowAction;
import com.gegejia.flow.execution.FlowContext;

/**
 * @author footmanff on 2018/10/22.
 */
public class Step1 implements FlowAction<Integer, String> {

    @Override
    public void execute(FlowContext<Integer, String> flowContext) {
        System.out.println("step1");
    }
    
}
