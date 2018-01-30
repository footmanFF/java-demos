package com.fm.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author footmanff on 2017/8/22.
 */
public class Utils {

    public final static <T> List<T> newList(T... s){
        if(s == null){
            return Collections.emptyList();
        }
        return Arrays.stream(s).collect(Collectors.toList());
    }

    public final static <T> T[] newArray(T... t){
        if(t == null){
            return null;
        }
        return t;
    }

    public final static List<String> newTestStringList(){
        return newList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    public final static String[] newTestStringArray(){
        return newArray("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
