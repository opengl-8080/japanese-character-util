package com.github.opengl8080.kanatil;

public class Kanatil {

    public static boolean isHalfwidthKana(char c) {
        return 0xFF61 <= c && c <= 0xFF9F;
    }

}
