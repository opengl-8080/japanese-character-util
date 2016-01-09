package com.github.opengl8080.kanatil;

public class Kanatil {

    public static boolean isHalfwidthKanaSymbol(char c) {
        return 0xFF61 <= c && c <= 0xFF65
                || 0xFF9E <= c && c <= 0xFF9F
                || 0xFF70 == c;
    }

    public static boolean isHalfwidthKana(char c) {
        return 0xFF61 <= c && c <= 0xFF9F;
    }

}
