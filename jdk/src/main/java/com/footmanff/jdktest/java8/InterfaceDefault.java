package com.footmanff.jdktest.java8;

import org.junit.Test;

/**
 * http://ebnbin.com/2015/12/20/java-8-default-methods/
 * 
 * @author footmanff on 2018/10/17.
 */
public class InterfaceDefault {

    @Test
    public void test1() {
        new ClassA().foo(); // 打印：“InterfaceA foo”
    }

    interface InterfaceA {
        default void foo() {
            System.out.println("InterfaceA foo");
        }
    }

    static class ClassA implements InterfaceA {
    }
    
}
