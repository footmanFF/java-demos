package com.footmanff.jdktest.gc;

import java.util.concurrent.TimeUnit;

/**
 * Created by fm on 2017/3/18.
 */
public class MinorGcTest {

    public static void main(String[] args) throws Exception{
        while(true){
            byte[] bytes = new byte[200 * 1024 * 1024];
            /**
             * -Xms2000m -Xmx2000m 下，疯狂minor gc，4核mac下cpu占用
             * sleep 200L 为10%
             * sleep 50L 为30%
             * sleep 0   为90+%
             *
             * 新生代使用 Parallel scavenge收集器，gc时候会stop the world，然后进行多线程gc
             */
            TimeUnit.MILLISECONDS.sleep(50L);
        }
    }

}
