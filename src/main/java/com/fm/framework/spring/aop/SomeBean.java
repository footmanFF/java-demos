package com.fm.framework.spring.aop;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by fm on 2017/4/23.
 */
@Component
public class SomeBean {

    public void doSomeThing(String str){
        System.out.println("call doSomeThing " + str);
    }

    public void doThrow(){
        System.out.println("call doThrow ");
        // throw new RuntimeException("RuntimeException throwed");
    }

    public String doReturn(){
        System.out.println("call doThrow ");
        return "success";
    }

    @Scheduled
    public void task(){
        System.out.println("call task");
    }



}
