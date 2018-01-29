package com.fm.java.java8;

import com.fm.util.Utils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangli on 2017/8/22.
 */
public class StringTest extends Utils{

    @Test
    public void test1(){
        System.out.println(String.join("|", newTestStringList()));
    }

    @Test
    public void test2() {
        System.out.println(Arrays.asList(new String[]{}));
    }

    public static void main(String[] args) {
        System.out.println("aa");
    }
    
}
