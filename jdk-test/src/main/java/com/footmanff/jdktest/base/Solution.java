package com.footmanff.jdktest.base;

/**
 * @author footmanff on 06/03/2018.
 */
/*
 *输入一个Long数组，按要求输出一个等长的Long数组
 *输出数组的元素值等于，输入数组除相同下标外其他元素的积
 * 如：输入[1, 2,3,4], 输出[24,12,8,6]
 * 输出数组：output[0]=input[1]*input[2]*input[3]，即24=2*3*4
 *         output[1]=input[0]*input[2]*input[3]，即12=1*3*4
 * 要求：
 *1. 需要在O(n)复杂度内完成操作
 *2. 不需要考虑乘积越界的问题
 */
public class Solution {


    public static void main(String[] args) {
        long[] ls = {1, 2, 3, 4};
        ls = calc(ls);
        for (int i = 0; i < ls.length; i++) {
            System.out.println(ls[i]);
        }
    }

    public static long[] calc(long[] array) {
        if (array.length == 0 || array == null) {
            return new long[]{};
        }

        // 1:非0   0:为0
        byte[] bits = new byte[array.length];
        long total = 1L;
        int zero = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zero++;
                bits[i] = 0;
            } else {
                bits[i] = 1;
                total = total * array[i];
            }
        }
        long[] newArray = new long[array.length];
        if (zero >= 2) {
            return newArray;
        }

        for (int i = 0; i < array.length; i++) {
            if (bits[i] == 1) {
                if (zero > 0) {
                    // 乘积为0
                    newArray[i] = 0L;
                } else {
                    newArray[i] = total / array[i];
                }
            } else {
                // 当前循环到0
                if (zero == 1) {
                    // 并且只有一个0，返回其他的乘积
                    newArray[i] = total;
                } else {
                    // 不止一个0，沉积一定为0
                    newArray[i] = 0L;
                }
            }
        }
        return newArray;
    }

}
