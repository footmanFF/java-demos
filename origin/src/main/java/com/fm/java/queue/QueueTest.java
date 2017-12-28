package com.fm.java.queue;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {

    @Test
    public void t(){
        Queue queue = new ArrayBlockingQueue(1);
        queue.add(1);
        queue.offer(1);
        System.out.println(queue);

        queue = new ArrayBlockingQueue(1);
        queue.add(1);
        queue.add(1);
        System.out.println(queue);

    }

    @Test
    public void t2() {
        Collection set = new HashSet();
        System.out.println(set.add("1"));
        System.out.println(set.add("1"));
    }
}
