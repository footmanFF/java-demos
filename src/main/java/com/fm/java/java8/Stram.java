package com.fm.java.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static com.fm.util.Utils.*;

/**
 * @author zhangli on 2017/8/22.
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
        List list = newList("1", "2", "3").stream().filter((t) -> {
            if(t.equals("1")){
                return false;
            }
            return true;
        }).collect(Collectors.toList());

        System.out.println(list);
    }

}