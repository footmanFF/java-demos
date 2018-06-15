package com.footmanff.jdktest.base;

/**
 * @author footmanff on 11/02/2018.
 */
public class TestClass {

    private int m;

    public int inc() {
        return m + 1;
    }

    public static void main(String[] args) {
        
        
        int COUNT_BITS = 29;
        int CAPACITY = (1 << COUNT_BITS) - 1;
        System.out.println(1 << COUNT_BITS);


        System.out.println(CAPACITY);
        System.out.println(Integer.toBinaryString(CAPACITY));

        
        // 011111111 11111111 11111111 1111111
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        // 10000000 00000000 00000000 00000000
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

        // 11100000 00000000 00000000 00000000
        System.out.println(Integer.toBinaryString(-1 << COUNT_BITS));

        // 00000000 00000000 00000000 00000000
        System.out.println(Integer.toBinaryString(0 << COUNT_BITS));

        // 00100000 00000000 00000000 00000000
        System.out.println(Integer.toBinaryString(1 << COUNT_BITS));

        // 01000000 00000000 00000000 00000000
        System.out.println(Integer.toBinaryString(2 << COUNT_BITS));

        // 01100000 00000000 00000000 00000000
        System.out.println(Integer.toBinaryString(3 << COUNT_BITS));

        // 11111111111111111101100011111001
        System.out.println(Integer.toBinaryString(-9991));

        // 11111111111111111101100011111001
        System.out.println(Integer.toBinaryString(-9991 & -1));
        
        int i = 0;
        int b = 5;
        i = b = 10;
        System.out.println(i);
        System.out.println(b);
        
        
    }
    
}
