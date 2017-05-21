package com.fm.algorithm;

import com.google.common.primitives.Ints;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * Created by zhangli on 2017/5/15.
 */
public class BigFileSortWithSmallMemory {

    private String testFilePath = "/tmp/ttt";
    private String showFilePath = "/tmp/ttt_show";
    private int numberCount = 1000;

    private RandomAccessFile randomAccessFile;
    private boolean isShowNumbers = false;

    @Before
    public void init() throws Exception {
        randomAccessFile = new RandomAccessFile(new File(testFilePath), "rwd");
    }

    @Test
    public void showNumbersByFile() throws Exception {
        saveNumbersToFile();
    }

    @Test
    public void sortFileNumbers() throws Exception {
        readAndShow();

        long count = numberCount();
        for (long a = count - 1; a >= 0; a--) {
            for (long i = 0; i < a; i++) {
                int this_ = getNumberByPoint(i);
                int next = getNumberByPoint(i + 1);
                if (next < this_) {
                    setNumberByPoint(i, next);
                    setNumberByPoint(i + 1, this_);
                    System.out.println("swap " + this_ + " - " + next);
                } else {
                    System.out.println("remain " + this_ + " - " + next);
                }
            }
            randomAccessFile.seek(0L);
        }
        readAndShow();
        randomAccessFile.close();
    }

    @Test
    public void createBigNumberFile() throws Exception {
        File file = new File(testFilePath);
        Random r = new Random();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        for (int i = 0; i < numberCount; i++) {
            int next = r.nextInt(Integer.MAX_VALUE);
            System.out.println(next);
            bufferedOutputStream.write(Ints.toByteArray(next));
            if (i % 1000 == 0) {
                bufferedOutputStream.flush();
            }
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    private int getNumberByPoint(long point) throws Exception {
        try {
            randomAccessFile.seek(point * 4L);
            return randomAccessFile.readInt();
        } catch (EOFException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void setNumberByPoint(long point, int value) throws Exception {
        randomAccessFile.seek(point * 4L);
        randomAccessFile.writeInt(value);
    }

    private long numberCount() throws IOException {
        return randomAccessFile.length() / 4L;
    }

    private void readAndShow() throws IOException {
        if (isShowNumbers) {
            showNumbers();
        }
    }

    private void showNumbers() throws IOException {
        randomAccessFile.seek(0L);
        long c = numberCount();
        for (long i = 0L; i < c; i++) {
            System.out.println(randomAccessFile.readInt());
        }
    }

    private void saveNumbersToFile() throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(showFilePath)));

        long c = numberCount();
        for (long i = 0L; i < c; i++) {
            int r = randomAccessFile.readInt();
            System.out.println(r);
            bufferedWriter.write(r + "");
            bufferedWriter.write("\n");
            if (i % 1000 == 0) {
                bufferedWriter.flush();
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
