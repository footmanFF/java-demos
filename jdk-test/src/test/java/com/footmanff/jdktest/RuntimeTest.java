package com.footmanff.jdktest;

import org.junit.Test;

/**
 * @author zhangli on 29/01/2018.
 */
public class RuntimeTest {

    /**
     * kill杀进程的话并不会执行hook
     */
    @Test
    public void addShutdownHookTest() throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hook!");
            }
        }));
        Thread.sleep(999999999L);
    }
    
}
