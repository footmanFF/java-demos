package com.fm.rpc;

/**
 * Created by fm on 2017/3/31.
 */
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
        return "Hello " + name;
    }

}