package com.fm.java.util;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fm on 2017/3/8.
 */
public class HashMapDemos {

    @Test
    public void t1(){
        Map<String, String> map = new HashMap<>(4); // table.length > 数组长度 * 加载因子(0.75) 时候扩容
        map.put("1", "");
        map.put("2", "");
        map.put("3", "");
        map.put("4", "");

        // 最后一次put会触发扩容

        int a = 0;
    }

}
