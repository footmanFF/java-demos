package com.fm.oj;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * https://www.codewars.com/kata/534ea96ebb17181947000ada
 * Created by zhangli on 2017/6/2.
 */
public class Chocolate {

    public static int breakChocolate(int n, int m) {
        if(n <=0 || m <=0){
            return 0;
        }
        if(n == 1 && m == 1){
            return 0;
        }
        if(n > m){
            return a(n, m);
        } else {
            return a(m, n);
        }
    }

    private static int a(int small, int big){
        return (small - 1) * 1 + (big - 1) * small;
    }

    @Test
    public void myTests() {
        assertEquals(Chocolate.breakChocolate(5, 5) , 24);
        assertEquals(Chocolate.breakChocolate(1, 1) , 0);
        assertEquals(Chocolate.breakChocolate(0, 0) , 0);
    }

}
