package com.footmanff.jdktest.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author footmanff on 2017/8/21.
 */
public class Lambda {

    public static void main(String[] args) {
        Lambda.handleStr("some string", t -> System.out.println(t.length()));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(t -> System.out.println(t));

        list.forEach(System.out::println);

        evaluate(list, t -> t > 5);

        list.stream()
                .map(n -> n * n)
                .forEach(n -> System.out.println(n));

        list.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n));

        list.stream()
                .map(n -> n * n)
                .reduce((a, b) -> a + b)
                .get();
    }

    public static void handleStr(String str, Handler<String> handler) {
        handler.handle(str);
    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

    @FunctionalInterface
    private interface Handler<T> {
        void handle(T t);
    }

}
