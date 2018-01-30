package com.fm.java.base;

import org.junit.Test;

/**
 * Created by footmanff on 2017/5/3.
 */
public class SwitchTest {

    @Test
    public void switchTest(){
        System.out.println(doSwitch("a"));
        System.out.println(doSwitch("b"));
        System.out.println(doSwitch("ab"));
    }

    private String doSwitch(String str){
        switch (str) {
            case "a":
            case "b":
                return "a-b";
        }
        return "default";
    }

}
