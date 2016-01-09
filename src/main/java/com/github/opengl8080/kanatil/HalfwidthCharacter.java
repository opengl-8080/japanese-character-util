package com.github.opengl8080.kanatil;

public class HalfwidthCharacter {

    public static boolean isHalfwidthSymbol(char c) {
        return 0xFF61 <= c && c <= 0xFF65
                || 0xFF9E <= c && c <= 0xFF9F
                || 0xFF70 == c;
    }

    public static boolean isHalfwidthCharacter(char c) {
        return 0xFF66 == c
                || isHalfwidthLowerCharacter(c)
                || 0xFF71 <= c && c <= 0xFF9D;
    }
    
    public static boolean isHalfwidth(char c) {
        return isHalfwidthSymbol(c)
                || isHalfwidthCharacter(c);
    }

    public static boolean isHalfwidthLowerCharacter(char c) {
        return 0xFF67 <= c && c <= 0xFF6F;
    }

    public static boolean isHalfwidthCharacter(String string) {
        if (isEmpty(string) || hasSurrogatePair(string)) {
            return false;
        }
        
        for (char c : string.toCharArray()) {
            if (!isHalfwidthCharacter(c)) {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }
    
    private static boolean hasSurrogatePair(String string) {
        int length = string.length();
        int codePointLength = string.codePointCount(0, length);
        
        return length != codePointLength;
    }

    public static boolean isHalfwidthSymbol(String string) {
        if (isEmpty(string) || hasSurrogatePair(string)) {
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
        if (isEmpty(string) || hasSurrogatePair(string)) {
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
