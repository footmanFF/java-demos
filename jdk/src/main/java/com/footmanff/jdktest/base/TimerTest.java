package com.footmanff.jdktest.base;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author footmanff on 2018/7/6.
 */
public class TimerTest {

    @Test
    public void time() throws Exception {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1");
            }
        }, 1L, 1000L);
        while (true) {
            Thread.sleep(10000L);
        }
    }
    
}
