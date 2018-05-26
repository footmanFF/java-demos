package com.footmanff.jdktest.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.footmanff.jdktest.Utils.*;

/**
 * @author footmanff on 2017/8/22.
 */
public class Stram {

    @Test
    public void test1() {
        String[] strs = newArray("1", "2", "3");

        List list = Arrays.stream(strs)
                .map((t) -> {
                    String a = t + "_";
                    return a;
                })
                .collect(Collectors.toList());

        System.out.println(list);
    }

    @Test
    public void test2() {
        List list = newList("1", "2", "3").stream()
                .filter((t) -> {
                    if (t.equals("1")) {
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());

        System.out.println(list);
    }

    @Test
    public void test3() {
        Map<Integer, List<String>> map = newList("1", "12", "XX", "123", "XXX")
                .stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }

    @Test
    public void test4() {
        Map<Integer, Map<String, List<String>>> map = newList("1", "12", "XX", "123", "XXX", "XX", "1")
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.groupingBy(String::toString)));
        map.forEach((k, v) -> {
            System.out.println(k + " :    " + v);
        });
    }

}