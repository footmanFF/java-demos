package com.footmanff.jdktest.nio.disk;

import com.footmanff.jdktest.util.TestFileBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Random;

/**
 * @author footmanff on 2018/6/15.
 */
@Slf4j
public class FileChannelTest {

    @Test
    public void t1() throws Exception {
        File file = new File("/tmp/tt");
        if (!file.exists()) {
            file.createNewFile();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        int rowNumber = 1;
        for (int i = 0; i < 10000; i++) {
            byteBuffer.clear();
            byteBuffer.put((rowNumber + " 你好啊，世界\n").getBytes(Charset.forName("utf-8")));
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            rowNumber++;
        }
        System.out.println(fileChannel.position());
        randomAccessFile.close();
    }

    @Test
    public void t2() throws Exception {
        String path = "/tmp/tt";
        TestFileBuilder.testFile1(path);
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(path), "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int row = r.nextInt(100) + 1;
            byteBuffer.clear();
            fileChannel.read(byteBuffer, row);
            byteBuffer.flip();
            CharBuffer charBuffer = Charset.defaultCharset().decode(byteBuffer);
            log.info("row: {} content: {}", row, charBuffer);
        }
        randomAccessFile.close();
    }

    @Test
    public void t3() throws Exception {
        String path = "/tmp/tt";
        TestFileBuilder.testFile1(path);
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(path), "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());

    }
}