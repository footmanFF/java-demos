package com.fm.java.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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

}
