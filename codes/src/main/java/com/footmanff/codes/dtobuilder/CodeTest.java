package com.footmanff.codes.dtobuilder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author footmanff on 2018/8/29.
 */
public class CodeTest {

    @Test
    public void test2() {
        List<Integer> list = new ArrayList();
        for (int i = 1; i <= 101; i++) {
            list.add(i);
        }

        List<Integer> temp = list.stream().map(e -> {
            if (e < 10) {
                return e;
            } else {
                return null;
            }
        }).collect(Collectors.toList());
        System.out.println(temp);
    }

    @Test
    public void test1() {
        List list = new ArrayList();
        for (int i = 1; i <= 101; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i += 10) {
            int toIndex = i + 10 > list.size() ? list.size() : i + 10;
            List temp = list.subList(i, toIndex);
            System.out.println(temp);
        }
    }

}
