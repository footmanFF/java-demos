package com.fm.framework.spring.aop;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author zhangli on 2017/8/23.
 */
public interface SubInterfaceTest extends InterfaceTest {

    void print();

    @AnnoAop
    void print2();
    
    String getString();

}
