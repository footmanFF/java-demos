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

    /**
     * Collectors.groupingBy
     * 根据单层key归类
     */
    @Test
    public void test3() {
        Map<Integer, List<String>> map = newList("1", "12", "XX", "123", "XXX")
                .stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }

    /**
     * Collectors.groupingBy
     * 根据多层key归类
     */
    @Test
    public void test4() {
        Map<Integer, Map<String, List<String>>> map = newList("1", "12", "XX", "123", "XXX", "XX", "1")
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.groupingBy(String::toString)));
        map.forEach((k, v) -> {
            System.out.println(k + " :    " + v);
        });
    }

    /**
     * Collectors.toMap
     * key冲突处理策略
     */
    @Test
    public void test5() {
        Map<Integer, String> map = newList("1", "12", "XX", "123", "XXX", "XX", "1")
                .stream()
                .collect(Collectors.toMap(String::length, String::toString, (v1, v2) -> {
                    return v1 + ", " + v2;
                }));
        map.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }

    /**
     * Collectors.toMap
     * key冲突的情况
     */
    @Test
    public void test6() {
        newList("1", "12", "XX", "123", "XXX", "XX", "1")
                .stream()
                .collect(Collectors.toMap(String::length, s -> s));
        // java.lang.IllegalStateException: Duplicate key 12
    }

    /**
     * Collectors.toMap例子
     * toMap(Function<? super T, ? extends K> keyMapper,
     * Function<? super T, ? extends U> valueMapper,
     * BinaryOperator<U> mergeFunction,
     * Supplier<M> mapSupplier)
     */
    @Test
    public void test7() {
        Map<Integer, String> map = new HashMap();
        newList("1", "12", "XX", "123", "XXX", "XX", "1")
                .stream()
                .collect(Collectors.toMap(
                        String::length,
                        s -> s,
                        (v1, v2) -> v1 + " , " + v2,
                        () -> map
                ));
    }

    @Test
    public void test8() {
        Map<Integer, String> map = new HashMap();
        new ArrayList<String>()
                .stream()
                .collect(Collectors.toMap(
                        String::length,
                        s -> s,
                        (v1, v2) -> v1 + " , " + v2,
                        () -> map
                ));
        System.out.println(map);
    }

}