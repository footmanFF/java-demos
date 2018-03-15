package com.footmanff.jdktest.concurrent;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fm on 2017/3/7.
 */
public class SmallDemos {

    /**
     * ExecutorService 例子
     */
    @Test
    public void t1() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> result = executorService.submit(() -> {
            Random random = new Random();
            Thread.sleep(3000);
            return random.nextInt(10);
        });

        while (!result.isDone()) {
            Thread.sleep(500);
            System.out.println("未获取");
        }

        System.out.println("获取:" + result.get());
    }

    /**
     * Thread.join() 例子
     */
    @Test
    public void t2() throws Exception {
        Thread t1 = new Thread(() -> {
            int c = 5;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (c > 0) {
                c = c - 1;
                System.out.println("t1:" + c);
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2:join");
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2:end");
        });

        t1.start();
        t2.start();

        Thread.sleep(10000);
    }

    /**
     * interrupt
     */
    @Test
    public void t3() throws Exception {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }

    /**
     * UncaughtExceptionHandler
     */
    @Test
    public void t4() throws Exception {
        Thread t1 = new Thread(() -> {
            throw new RuntimeException("异常");
        });
        t1.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("获取到异常：" + e);
        });
        t1.start();
    }

    /**
     * Lock
     */
    @Test
    public void t5() throws Exception {
        final ReentrantLock lock = new ReentrantLock(true);

        lock.lock();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                lock.unlock();
            }
        });
        t.start();
        
        try {
            // do something
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //lock.unlock();
        }
        
        Thread.sleep(Long.MAX_VALUE);
    }


    /**
     * trylock
     */
    @Test
    public void t6() {
        Lock lock = new ReentrantLock();

        boolean isAcquiredSuccess = false;

        try {
            isAcquiredSuccess = lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (isAcquiredSuccess) {
                lock.unlock();
            }
        }

        try {
            isAcquiredSuccess = lock.tryLock(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (isAcquiredSuccess) {
                lock.unlock();
            }
        }
    }

    /**
     * 并发-可见性
     */
    private boolean ready = false;
    private int number = 1;
    @Test
    public void t7() throws Exception{
        new Thread(() -> {
           while (!ready){
               Thread.yield();
           }
           System.out.println(number);   // 按照理论这里可能输出1，但是实际测试无法出现
        }).start();
        ready = true;
        number = 2;
        Thread.sleep(3000L);
    }

}