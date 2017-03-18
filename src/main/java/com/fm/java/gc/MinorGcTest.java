package com.fm.java.gc;

import java.util.concurrent.TimeUnit;

/**
 * Created by fm on 2017/3/18.
 */
public class MinorGcTest {

    /**
     * -Xms2000m -Xmx2000m 下，疯狂minor gc，4核mac下cpu占用为10%
     */
    public static void main(String[] args) throws Exception{
        while(true){
            byte[] bytes = new byte[200 * 1024 * 1024];
            TimeUnit.MILLISECONDS.sleep(200L);
        }
    }

}
