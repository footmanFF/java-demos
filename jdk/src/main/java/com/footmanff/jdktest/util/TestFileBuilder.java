package com.footmanff.jdktest.util;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author footmanff on 2018/6/29.
 */
public class TestFileBuilder {
    
    public static void testFile1(String path){
        RandomAccessFile randomAccessFile = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
            int rowNumber = 1;
            for (int i = 0; i < 100000; i++) {
                byteBuffer.clear();
                byteBuffer.put((rowNumber + " 你好啊，世界\n").getBytes(Charset.forName("utf-8")));
                byteBuffer.flip();
                fileChannel.write(byteBuffer);
                rowNumber++;
            }
            System.out.println(fileChannel.position());
            randomAccessFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
