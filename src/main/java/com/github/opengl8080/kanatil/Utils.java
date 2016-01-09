package com.github.opengl8080.kanatil;

public class Utils {
    
    private Utils() {}

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean hasSurrogatePair(String string) {
        if (string == null) return false;
        
        int length = string.length();
        int codePointLength = string.codePointCount(0, length);
        
        return length != codePointLength;
    }
}
