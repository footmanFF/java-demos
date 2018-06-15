package com.footmanff.jdktest.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 先进先出队列（First In First Out）
 * Created by fm on 2017/3/17.
 */
public class FIFOQueue {

    private List<String> queue = new ArrayList<>();
    private int max = 10;

    /**
     * <p>这里用while而不是if的目的是为了让wait被唤醒以后，继续执行下面的逻辑之前保证condition是正确的
     * 有可能有其他的线程调用了某个方法，在wait被唤醒的刹那改变了condition，如果是if的话，wait被唤醒
     * 之后就无法保证程序逻辑正确了
     *
     * <p>还有一种情况是当其他根本不是一个业务的方法调用在对象上调用了notify，那么while(condition)保证了
     * 即使被唤醒也会继续进入等待状态，程序逻辑是一致的
     *
     * 《Java 编程思想》711页
     * @param item
     * @throws InterruptedException
     */
    public synchronized void push(String item) throws InterruptedException{
        while (queue.size() >= max) {
            wait();
        }
        queue.add(item);
        notifyAll();
    }

    public synchronized String pop() throws InterruptedException{
        while (queue.isEmpty()) {
            wait();
        }
        String str = queue.remove(0);
        notifyAll();
        return str;
    }

    public static void main(String[] args) throws Exception {
        FIFOQueue producerAndConsumer = new FIFOQueue();
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    producerAndConsumer.push("item" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            latch.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    System.out.println(producerAndConsumer.pop());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            latch.countDown();
        }).start();

        latch.await();
        System.out.println("END");
    }

}
