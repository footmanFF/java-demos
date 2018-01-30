package com.footmanff.jdktest.bit;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author footmanff on 2017/11/5.
 */
public class BitTest {

    @Test
    public void test1() {
        assertEquals(1 << 1, 2);

        assertEquals(2 >> 1, 1);
    }

    @Test
    public void test2() {
        // 判断奇偶数: 最未位是 0 还是 1 来决定，为 0 就是偶数，为 1 就是奇数
        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0) { // 偶数
                System.out.println(i);
            }
            if ((i & 1) == 1) { // 奇数
                System.out.println(i);
            }
        }
    }

}
