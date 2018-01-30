package com.fm.oj;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * https://www.codewars.com/kata/566fc12495810954b1000030
 * Created by footmanff on 2017/6/2.
 */
public class CountDig {

    public static int nbDig(int n, int d) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int c = i * i;
            count = count + countNumber(c, d);
        }
        return count;
    }

    /**
     * 统计base中number出现的次数
     * @param base
     * @param number
     * @return
     */
    private static int countNumber(int base, int number){
        String str = base + "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if((str.charAt(i) + "").equals(number + "")){
                count ++;
            }
        }
        return count;
    }

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests nbDig");
        testing(CountDig.nbDig(5750, 0), 4700);
        testing(CountDig.nbDig(11011, 2), 9481);
        testing(CountDig.nbDig(12224, 8), 7733);
        testing(CountDig.nbDig(11549, 1), 11905);
    }

}
