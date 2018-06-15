package com.footmanff.jdktest.base;

/**
 * @author footmanff on 09/03/2018.
 */
public class JMMTest {

    int a = 0;
    volatile boolean flag = false;
    public void writer() {
        a = 1;                   //1
        flag = true;               //2
    }
    public void reader() {
        if (flag) {                //3
            int i =  a;           //4
        }
    }
    
}