package com.footmanff.jdktest.java8;

import org.junit.Test;

import java.util.OptionalInt;

/**
 * @author footmanff on 2018/5/18.
 */
public class OptionalTest {
    
    @Test
    public void test1(){
        OptionalInt optionalInt = OptionalInt.of(10);
        optionalInt.orElse(5);
    }
    
}
