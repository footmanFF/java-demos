package com.footmanff.jdktest.nio.disk;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 来自《Oreilly.Java.NIO》3.3.1 节
 */
public class FileHole {

    public static void main(String[] argv) throws IOException {
        File temp = File.createTempFile("holy", null);

        RandomAccessFile file = new RandomAccessFile(temp, "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);

        putData(0, byteBuffer, channel);
        putData(5000000, byteBuffer, channel);
        putData(50000, byteBuffer, channel);

        // Size will report the largest position written, but 
        // there are two holes in this file. This file will 
        // not consume 5 MB on disk (unless the filesystem is 
        // extremely brain-damaged)
        
        System.out.println("Wrote temp file '" + temp.getPath() + "', size=" + channel.size());
        channel.close();
        file.close();
    }

    private static void putData(int position, ByteBuffer buffer, FileChannel channel) throws IOException {
        String string = "*<-- location " + position;
        buffer.clear();
        buffer.put(string.getBytes("US-ASCII"));
        buffer.flip();
        channel.position(position);
        channel.write(buffer);
    }

}
