package com.github.opengl8080.kanatil;

public class FullwidthString {

    public static boolean isHiragana(Character c) {
        if (c == null) return false;
        return isHiragana(c.charValue());
    }

    public static boolean isHiragana(char c) {
        return '\u3041' <= c && c <= '\u3093';
    }

    public static boolean isKatakana(Character c) {
        if (c == null) return false;
        return isKatakana(c.charValue());
    }

    public static boolean isKatakana(char c) {
        return '\u30A1' <= c && c <= '\u30F4';
    }

    public static boolean isHiragana(String string) {
        if (Utils.isEmpty(string) || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        for (char c : string.toCharArray()) {
            if (!isHiragana(c)) {
                return false;
            }
        }
        
        return true;
    }

    public static boolean isKatakana(String string) {
        if (Utils.isEmpty(string) || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        for (char c : string.toCharArray()) {
            if (!isKatakana(c)) {
                return false;
            }
        }
        
        return true;
    }

}
