package com.fm.oj;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * https://www.codewars.com/kata/5552101f47fc5178b1000050
 * Created by footmanff on 2017/6/2.
 */
public class DigPow {

    public static long digPow(int n, int p) {
        // your code

        // (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k

        String str = String.valueOf(n);

        double count = 0;
        for (int i = 0; i < str.length(); i++) {
            int number = Integer.valueOf(str.charAt(i) + "");
            count = count + Math.pow(number, p);
            p = p + 1;
        }
        double d = count / Double.valueOf(n);
        int di = Double.valueOf(d).intValue();
        if(d > di){
            return -1;
        } else {
            return di;
        }
    }

    @Test
    public void Test() {
        // assertEquals(-1, DigPow.digPow(92, 1));
        assertEquals(1, DigPow.digPow(89, 1));
        assertEquals(51, DigPow.digPow(46288, 3));
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(4, 2));
        System.out.println(Math.log(15) / Math.log(2));
    }

}
