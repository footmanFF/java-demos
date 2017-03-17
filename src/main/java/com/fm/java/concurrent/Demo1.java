package com.fm.java.concurrent;

/**
 * Created by fm on 2017/3/13.
 */
public class Demo1 {

    public static void main(String[] args) {
        final Unsafe[] leak = new Unsafe[1];
        new Thread(() -> {
            Thread.yield();   // (or sleep for a bit)
            new Unsafe(leak);
        }).start();

        while (true) {
            // System.out.println("aa");
            if (leak[0] != null) {
                if (leak[0].foo == 42) {
                    System.err.println("OK");
                } else {
                    System.err.println("OUCH!");
                }
                System.exit(0);
            }
        }
    }

    private static class Unsafe {
        public final int foo = 42;
        byte[] a;
        public Unsafe(Unsafe[] leak) {
            leak[0] = this;   // Unsafe publication
            // Make the "window of vulnerability" large
            for (long l = 0; l < Integer.MAX_VALUE ; l++) {
                a = new byte[100000000];
            }
        }
    }

}