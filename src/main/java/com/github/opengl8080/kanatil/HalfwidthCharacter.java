package com.github.opengl8080.kanatil;

public class HalfwidthCharacter {

    public static boolean isHalfwidthKanaSymbol(char c) {
        return 0xFF61 <= c && c <= 0xFF65
                || 0xFF9E <= c && c <= 0xFF9F
                || 0xFF70 == c;
    }

    public static boolean isHalfwidthKanaCharacter(char c) {
        return 0xFF66 <= c && c <= 0xFF6F
                || 0xFF71 <= c && c <= 0xFF9D;
    }
    
    public static boolean isHalfwidthKana(char c) {
        return isHalfwidthKanaSymbol(c) || isHalfwidthKanaCharacter(c);
    }

    public static boolean isHalfwidthKanaLowerCharacter(char c) {
        return 0xFF67 <= c && c <= 0xFF6F;
    }
}
