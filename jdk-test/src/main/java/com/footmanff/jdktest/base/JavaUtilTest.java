package com.footmanff.jdktest.base;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by footmanff on 2017/5/31.
 */
public class JavaUtilTest {

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("A", null);
        System.out.println(map.values().iterator().next());
    }

}
