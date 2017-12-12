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
        long s = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            someBean.task();
        }
        System.out.println("cost: " + (System.currentTimeMillis() - s));
        // 2187 1915 1870 1875
        // 1006 834  917  849
        someBean.doSomeThing("hello world");
        someBean.doReturn();
        someBean.doThrow();
        subInterfaceTest.print2();
        subInterfaceTest.getString();
        
    }

}
