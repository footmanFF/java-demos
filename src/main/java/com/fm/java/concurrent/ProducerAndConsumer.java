package com.fm.java.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 消费者生产者
 * Created by fm on 2017/3/17.
 */
public class ProducerAndConsumer {

    private List<String> queue = new ArrayList<>();
    private int max = 10;

    public void push(String item) {
        while (queue.size() >= max) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(item);
        this.notifyAll();
    }

    public String pop() {
        if (queue.isEmpty()) {
            this.notifyAll();
            while (queue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return queue.remove(0);
    }

    public static void main(String[] args) throws Exception {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                producerAndConsumer.push("item" + i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(producerAndConsumer.pop());
            }
        }).start();

        TimeUnit.SECONDS.sleep(5);
    }

}
