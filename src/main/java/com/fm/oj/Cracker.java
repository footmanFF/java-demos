package com.fm.oj;

import org.junit.Test;
import java.security.MessageDigest;
import java.util.*;

/**
 * https://www.codewars.com/kata/sha-256-cracker/train/java
 * Created by zhangli on 2017/5/31.
 */
public class Cracker {

    static List<String> loaded = new ArrayList<>();
    static Set<String> result = new HashSet<>(100);

    static String crackSha256(String hashStr, String chars) {

        List<String> charArray = Arrays.asList(chars.split(""));
        buildAllStr(charArray);

        for(String r : result){
            String hashed = sha256(r);
            if(hashed.equals(hashStr)){
                return r;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(crackSha256("b8c49d81cb795985c007d78379e98613a4dfc824381be472238dbd2f974e37ae", "deGioOstu"));

        System.out.println(sha256("GoOutside"));
    }

    @Test
    public void crackSha256Test() {
        buildAllStr(Arrays.asList("b", "c", "a"));
        System.out.println(result);
    }

    private static void buildAllStr(List<String> chars) {
        if(chars.size() == 1){
            result.add(buildLastString(chars.get(0)));
            return;
        }
        for(String c : chars){
            loaded.add(c);
            List<String> newChars = new LinkedList<>(chars);
            newChars.remove(c);
            buildAllStr(newChars);
            loaded.remove(loaded.size() - 1);

        }
        if(!loaded.isEmpty()){
//            loaded.remove(loaded.size() - 1);
        }
    }

    private static String buildLastString(String lastWord){
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : loaded){
            stringBuilder.append(str);
        }
        stringBuilder.append(lastWord);
        return stringBuilder.toString();
    }

    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
