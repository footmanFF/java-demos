package com.footmanff.jdktest.util;

import org.junit.Test;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fm on 2017/3/8.
 */
public class HashMapDemos {

    @Test
    public void t1(){
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
    }

    @Test
    public void t2() {
        int HASH_BITS = 0x7fffffff;
        int h = new Object().hashCode();
        System.out.println(Integer.toBinaryString(h));

        System.out.println(Integer.toBinaryString((h >>> 16)));

        int newHash = (h ^ (h >>> 16)) & HASH_BITS;

        System.out.println(Integer.toBinaryString(newHash));
    }

    /**
     * 测试HashMap.tableSizeFor方法
     */
    @Test
    public void t3() {
        System.out.println(pow(1));
        System.out.println(pow(2));
        System.out.println(pow(4));
        System.out.println(pow(6));
        System.out.println(pow(8));
        System.out.println(pow(9));
        System.out.println(pow(10));
        System.out.println(pow(11));
    }

    @Test
    public void t4() {
        /*
         * 对正数，无符号右移动1位，相当于执行除运算（舍弃余数）
         */
        System.out.println(1 >>> 1); // 0
        System.out.println(2 >>> 1); // 1
        System.out.println(3 >>> 1); // 1
        System.out.println(8 >>> 1); // 4

        System.out.println(1 / 2);
        System.out.println(2 / 2);
        System.out.println(3 / 2);
        System.out.println(8 / 2);
    }

    @Test
    public void t5() {
        new ConcurrentHashMap<>(2);
        new ConcurrentHashMap<>(10);
        new ConcurrentHashMap<>(56);
    }

    @Test
    public void t6() {
        // 9   m=8
        System.out.println(1 & 8);
        System.out.println(2 & 8);
        System.out.println(3 & 8);
        System.out.println(4 & 8);
        System.out.println(5 & 8);
        System.out.println(6 & 8);
        System.out.println(7 & 8);
        System.out.println(8 & 8);
        System.out.println(9 & 8);
        System.out.println(10 & 8);
        System.out.println(11 & 8);

        System.out.println(0 & 9);

        System.out.println(0x9e3779b9);
    }

    @Test
    public void t7() {
        for (int j = 0; j < 10; j++) {
            int i = 0x9e3779b9;
            StringBuilder str = new StringBuilder();
            int loop = 0;
            for(;;){
                if (loop > 10) {
                    break;
                }
                i = advanceProbe(i);
                str.append(i);
                str.append(", ");
                loop ++;
            }
            System.out.println(str);
        }
    }

    @Test
    public void t8() {
        System.out.println(20200 * 14);
        System.out.println(21200 * 16);
    }

    static final int advanceProbe(int probe) {
        probe ^= probe << 13;   // xorshift
        probe ^= probe >>> 17;
        probe ^= probe << 5;
        return probe;
    }
    
    private static int pow(int c){
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }
}
