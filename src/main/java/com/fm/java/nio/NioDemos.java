package com.fm.java.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * Created by zhangli on 2017/5/31.
 */
public class NioDemos {

    private String file = "/Users/zhangli/cloud/rule-data-center.md";

    @Test
    public void test() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fileChannel.read(buffer);
    }

    @Test
    public void test2() throws Exception {
        Selector selector = Selector.open();

//        channel1.register(selector, SelectionKey.OP_READ);
//        channel2.register(selector, SelectionKey.OP_WRITE);
//        channel3.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
//
//        // Wait up to 10 seconds for a channel to become ready 
//        readyCount = selector.select(10000);

    }

    @Test
    public void name() throws Exception {
        System.out.println(1 << 2);
    }
    
}
