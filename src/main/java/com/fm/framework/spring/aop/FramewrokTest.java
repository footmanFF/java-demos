package com.fm.framework.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fm on 2017/4/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class FramewrokTest {

    @Autowired
    private SomeBean someBean;

    @Autowired
    private SubInterfaceTest subInterfaceTest;

    @Test
    public void test(){
        someBean.task();
        someBean.doSomeThing("hello world");
        someBean.doReturn();
        someBean.doThrow();
        subInterfaceTest.print2();
    }

}
