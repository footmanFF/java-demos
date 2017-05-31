package com.fm.oj;

/**
 * https://www.codewars.com/kata/makeuppercase
 * Created by zhangli on 2017/5/31.
 */
public class Upper {

    public static String MakeUpperCase(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sb.append(Character.toUpperCase(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(MakeUpperCase("1232jaklsdFWEasegh"));
    }

}
