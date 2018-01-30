package com.footmanff.jdktest.classloader;

/**
 * Created by fm on 2017/3/31.
 */
public class FinalTest {

    public static int x = 6 / 3;

    static {
        System.out.println("init");
        x = 1;
    }

}
