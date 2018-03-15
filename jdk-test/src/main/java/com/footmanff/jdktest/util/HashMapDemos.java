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
}
