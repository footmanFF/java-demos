package com.fm.java.gc;

import org.junit.Test;

/**
 * @author zhangli on 2017/11/9.
 */
public class GcTest1 {
    
//    @Test
//    public void test1(){
//        byte[] a = new byte[6 * 1024 * 1024];
//        System.gc();
//    }
//
    @Test
    public void test2(){
        byte[] a = new byte[6 * 1024 * 1024];
        a = null;

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            s.append(i).toString().intern();
        }
        System.gc();
    }

    public static void main(String[] args) {
        String s = new String("AAA");
        System.out.println(s);
    }
    
}
