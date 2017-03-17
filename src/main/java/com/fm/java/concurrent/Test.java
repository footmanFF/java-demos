package com.fm.java.concurrent;

/**
 * Created by fm on 2017/3/13.
 */
public class Test {

    public static void main(String[] args) {
        ThreadLocal t = new ThreadLocal(){
            @Override
            protected Object initialValue() {
                return super.initialValue(); //
            }
        };
    }

}
