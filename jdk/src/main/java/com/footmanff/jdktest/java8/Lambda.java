package com.footmanff.jdktest.java8;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author footmanff on 2017/8/21.
 */
public class Lambda {

    public static void main1(String[] args) {
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

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("/tmp/es.data"));
        String line = null;
        StringBuilder s = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            s.append(line);
        }
        reader.close();
        JSONObject json = JSONObject.parseObject(s.toString());
        JSONArray array = json.getJSONObject("hits").getJSONArray("hits");
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/zhangli/.rally/benchmarks/data/data1/order_index_test_data.json"));

        // 20 0000
//        for (int i = 0; i < 10000; i++) {
//            writer.write(array.toJSONString());
//        }
        
        int c = 0;
        for (int i = 0; i < 100; i++) {
            for (Object obj : array) {
                JSONObject j = (JSONObject) obj;
                JSONObject source = j.getJSONObject("_source");
                writer.write(source.toJSONString());
                writer.write("\n");
                c ++;
            }
        }
        System.out.println(c);
        
        writer.flush();
        writer.close();
    }

}
