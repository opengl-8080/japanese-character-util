package com.github.opengl8080.kanatil;

public class HalfwidthString {

    public static boolean isHalfwidthSymbol(Character c) {
        if (c == null) return false;
        return isHalfwidthSymbol(c.charValue());
    }

    public static boolean isHalfwidthSymbol(char c) {
        return '\uFF61' <= c && c <= '\uFF65'
                || '\uFF9E' <= c && c <= '\uFF9F'
                || '\uFF70' == c;
    }

    public static boolean isHalfwidthCharacter(Character c) {
        if (c == null) return false;
        return isHalfwidthCharacter(c.charValue());
    }

    public static boolean isHalfwidthCharacter(char c) {
        return '\uFF66' == c
                || isHalfwidthLowerCharacter(c)
                || '\uFF71' <= c && c <= '\uFF9D';
    }
    
    public static boolean isHalfwidth(Character c) {
        if (c == null) return false;
        return isHalfwidth(c.charValue());
    }
    
    public static boolean isHalfwidth(char c) {
        return isHalfwidthSymbol(c)
                || isHalfwidthCharacter(c);
    }

    public static boolean isHalfwidthLowerCharacter(Character c) {
        if (c == null) return false;
        return isHalfwidthLowerCharacter(c.charValue());
    }

    public static boolean isHalfwidthLowerCharacter(char c) {
        return '\uFF67' <= c && c <= '\uFF6F';
    }

    public static boolean isHalfwidthCharacter(String string) {
        if (Utils.isEmpty(string) || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        for (char c : string.toCharArray()) {
            if (!isHalfwidthCharacter(c)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isHalfwidthSymbol(String string) {
        if (Utils.isEmpty(string) || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        for (char c : string.toCharArray()) {
            if (!isHalfwidthSymbol(c)) {
                return false;
            }
        }
        
        return true;
    }

    public static boolean isHalfwidth(String string) {
        if (Utils.isEmpty(string) || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        for (char c : string.toCharArray()) {
            if (!isHalfwidth(c)) {
                return false;
            }
        }
        
        return true;
    }
}
