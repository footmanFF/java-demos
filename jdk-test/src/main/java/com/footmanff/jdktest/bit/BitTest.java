package com.footmanff.jdktest.bit;

import org.junit.Test;
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
    
    /**
     * ForkJoinPool.externalSubmit中对workQueues初始化中，对数组容量的计算测试
     * <p>
     * n |= n >>> 1; n |= n >>> 2;  n |= n >>> 4;
     * n |= n >>> 8; n |= n >>> 16; n = (n + 1) << 1;
     */
    @Test
    public void test3() {
        for (int i = 0; i < 20; i++) {
            System.out.println("n init: " + i);
            createN(i);
            System.out.println();
            System.out.println();
        }
    }

    private int createN(int n) {
        n |= n >>> 1;
        System.out.println("n |= n >>> 1     ------- " + n);
        n |= n >>> 2;
        System.out.println("n |= n >>> 2     ------- " + n);
        n |= n >>> 4;
        System.out.println("n |= n >>> 4     ------- " + n);
        n |= n >>> 8;
        System.out.println("n |= n >>> 8     ------- " + n);
        n |= n >>> 16;
        System.out.println("n |= n >>> 16    ------- " + n);
        n = (n + 1) << 1;
        System.out.println("n = (n + 1) << 1 ------- " + n);
        return n;
    }
    
    @Test
    public void test4() {
        int a = 14;
        int b = a >>> 2;
        System.out.println(b);
        System.out.println(a | b);
    }
    
}
