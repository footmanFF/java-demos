package com.footmanff.jdktest.java8;

import org.junit.Test;

/**
 * http://ebnbin.com/2015/12/20/java-8-default-methods/
 * 
 * @author footmanff on 2018/10/17.
 */
public class InterfaceDefault2 {

    @Test
    public void test1() {
    }

    interface InterfaceA {
        default void foo() {
            System.out.println("InterfaceA foo");
        }
    }

    interface InterfaceB {
        default void bar() {
            System.out.println("InterfaceB bar");
        }
    }

    interface InterfaceC {
        default void foo() {
            System.out.println("InterfaceC foo");
        }

        default void bar() {
            System.out.println("InterfaceC bar");
        }
    }

    class ClassA implements InterfaceA, InterfaceB {
    }

    /* 
    错误
    class ClassB implements InterfaceB, InterfaceC {
    }
    */

    class ClassC implements InterfaceB, InterfaceC {
        @Override
        public void bar() {
            InterfaceB.super.bar(); // 调用 InterfaceB 的 bar 方法
            InterfaceC.super.bar(); // 调用 InterfaceC 的 bar 方法
            System.out.println("ClassB bar"); // 做其他的事
        }
    }    
    
}
