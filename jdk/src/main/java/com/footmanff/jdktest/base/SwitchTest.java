package com.footmanff.jdktest.base;

import org.apache.commons.codec.binary.Hex;
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

    public static void main(String[] args) throws Exception{
        byte[] t = Hex.decodeHex("6a6176612f6c616e672f4f626a656374");
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i]);
        }
        System.out.println();
        System.out.println("|" + new String(t, "utf-8") + "|");
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

}
