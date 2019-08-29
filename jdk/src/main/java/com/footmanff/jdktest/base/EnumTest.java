package com.footmanff.jdktest.base;

/**
 * @author footmanff on 2019/2/5.
 */
public class EnumTest {

    enum State {
        S1 {
            @Override
            void method() {
                System.out.println("hello");
            }
        };
        abstract void method();
    }

    public static void main(String[] args) {
        State state = State.S1;
        
        state.method();
    }

}
