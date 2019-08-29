package com.footmanff.codes.dtobuilder;

import com.vdurmont.emoji.EmojiParser;

import java.util.List;

/**
 * @author footmanff on 2018/12/17.
 */
public class Emoji {

    public static void main(String[] args) {
        String input = "A string 😄with a \uD83D\uDC66\uD83C\uDFFFfew 😉emojis!";
        System.out.println(input);
        String result = EmojiParser.removeAllEmojis(input);
        List<String> list = EmojiParser.extractEmojis(input);
        System.out.println(list);
    }
    
}
