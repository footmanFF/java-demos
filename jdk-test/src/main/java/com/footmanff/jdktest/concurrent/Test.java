package com.footmanff.jdktest.concurrent;

/**
 * @author footmanff on 22/03/2018.
 */
public class Test {

    public static void main(String[] args) {
        Bank b = new Bank();
//        new Thread(b,"女").start();
//        new Thread(b,"男").start();

        int a = 10;

        
        /*
            static final int DONE_MASK   = 0xf0000000;  // mask out non-completion bits
            static final int NORMAL      = 0xf0000000;  // must be negative
            static final int CANCELLED   = 0xc0000000;  // must be < NORMAL
            static final int EXCEPTIONAL = 0x80000000;  // must be < CANCELLED
            static final int SIGNAL      = 0x00010000;  // must be >= 1 << 16
            static final int SMASK       = 0x0000ffff;  // short bits for tags
         */
//        System.out.println(Integer.toBinaryString(0xf0000000));
//        
//        System.out.println(Integer.toBinaryString(0xf0000000));
//        System.out.println(Integer.toBinaryString(0xc0000000));
//        System.out.println(Integer.toBinaryString(0x80000000));
//        System.out.println(Integer.toBinaryString(0x00010000));
//        System.out.println(Integer.toBinaryString(0x0000ffff));
//        
//        int max = 120000;
//        System.out.println(Integer.toBinaryString(max));
//        short sh = (short)max;
//        System.out.println(Integer.toBinaryString((int)sh)); 
//        
//        Integer.valueOf(1).shortValue();
//
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(10 & i);
//        }
//
//        System.out.println(Integer.toBinaryString(8191));
//        System.out.println(1 << 13);
        
        /*
            // Active counts
            private static final int  AC_SHIFT   = 48;
            private static final long AC_UNIT    = 0x0001L << AC_SHIFT;
            private static final long AC_MASK    = 0xffffL << AC_SHIFT;
        
            // Total counts
            private static final int  TC_SHIFT   = 32;
            private static final long TC_UNIT    = 0x0001L << TC_SHIFT;
            private static final long TC_MASK    = 0xffffL << TC_SHIFT;
            private static final long ADD_WORKER = 0x0001L << (TC_SHIFT + 15); // sign
         */
        int AC_SHIFT = 48;
        int TC_SHIFT = 32;

        System.out.println(Long.toBinaryString(0x0001L << TC_SHIFT));
        System.out.println(Long.toBinaryString(0xffffL << TC_SHIFT));

        System.out.println(Long.toBinaryString(0xffffL << (TC_SHIFT + 15)));
        
        // 01111111 11111111 10000000 00000000 00000000 00000000 00000000 00000000
        System.out.println(Integer.toBinaryString(0x007e));
        System.out.println(0x007e);
        
        /*
            static final int LIFO_QUEUE   = 0;
           static final int FIFO_QUEUE   = 1 << 16;
         */
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1 << 16));
        // 0xffff
        System.out.println(Integer.toBinaryString(0xffff));
        System.out.println(0xffff);

        for (int i = 0; i < 100; i++) {
            System.out.print(" " + (i | (1 << 16)));
        }
    }


    static class Bank implements Runnable {

        private int money = 500;
        private int count = 0;

        @Override
        public void run() {
            for (int i = 1; i < 6; i++) {
                if (count > 4) {
                    System.out.println(Thread.currentThread().getName() + ":第 " + i + " : 次取款失败!");
                } else {
                    System.out.println(Thread.currentThread().getName() + ":第 " + i + " : 次取款开始!");
                    synchronized (this) {
                        money -= 100;
                        count++;
                    }
                }
            }
            System.out.println(count);
//            synchronized (this){
//                for (int i = 1; i < 6; i++) {
//                    if (count > 4){
//                        System.out.println(Thread.currentThread().getName() +":第 "+ i + " : 次取款失败!");
//                    }else{
//                        System.out.println(Thread.currentThread().getName() +":第 "+ i + " : 次取款开始!");
//                        synchronized (this){
//                            money -= 100;
//                            count ++;
//                        }
//                    }
//                }
//            }

        }
    }
}
