package com.footmanff.jdktest.concurrent;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author footmanff on 15/03/2018.
 */
public class UnsafeTest {

    /**
     * 测试Unsafe计算数组元素内存偏移地址
     * 一种方式：abase + scale * index
     * 另一种：abase + ((long)index << ashift)
     * 后者是ConcurrentHashMap中的写法，见tabAt方法
     */
    @Test
    public void t1() throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        Class<?> arrayClass = Object[].class;
        long abase = unsafe.arrayBaseOffset(arrayClass);
        int scale = unsafe.arrayIndexScale(arrayClass);
        int ashift = 31 - Integer.numberOfLeadingZeros(scale);

        // 数组下标
        int index = 8;
        System.out.println(abase + scale * index);
        System.out.println(abase + ((long) index << ashift));    // 左移等效 index * (ashift * 2)
        System.out.println(abase + ((long) index * ashift * 2));

        // 两种方式结果一致
    }

}