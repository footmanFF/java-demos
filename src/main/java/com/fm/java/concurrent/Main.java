package com.fm.java.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * sleep或其他会抛出InterruptedException的阻塞操作被调用时，当前线程被调用interrupt()
 * 就会抛出InterruptedException其余的情况程序只会继续运行，直到下一次的Thread.interrupted()检查
 * Created by fm on 2017/3/8.
 */
public class Main {

    public static void main(String[] args) throws Exception{
        /**
         * 设置运行不同时间，看Blocked的循环被中断在哪里，可以测试interrupt作用于
         * sleep和耗时逻辑不同的表现。前者
         */
        int sleep = 1650;
        Thread t = new Thread(new Blocked());
        t.start();
        TimeUnit.MILLISECONDS.sleep(sleep);
        t.interrupt();
    }

    static class NeedsCleanup {
        private final int id;

        public NeedsCleanup(int id) {
            this.id = id;
        }
        public void cleanUp(){
            System.out.println("clean up " + id);
        }
    }

    static class Blocked implements Runnable {
        private volatile double d = 0.0;
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()){
                    NeedsCleanup n1 = new NeedsCleanup(1);
                    try {
                        System.out.println("sleeping");
                        TimeUnit.SECONDS.sleep(1L);
                        System.out.println("sleeping end");
                        NeedsCleanup n2 = new NeedsCleanup(2);
                        try {
                            System.out.println("开始耗时操作");
                            for (int i = 0; i < 250000000 ; i++) {
                                d = d + (Math.PI + Math.E) / d;
                            }
                            System.out.println("结束耗时操作");
                        } finally {
                            n2.cleanUp();
                        }
                    } finally {
                        n1.cleanUp();
                    }
                }
                System.out.println("离开while");
            } catch (InterruptedException e) {
                System.out.println("外层异常 " + e);
            }
        }
    }

}
