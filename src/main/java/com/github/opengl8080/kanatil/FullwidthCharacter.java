package com.github.opengl8080.kanatil;

public class FullwidthCharacter {

    public static boolean isHiragana(Character c) {
        if (c == null) return false;
        return isHiragana(c.charValue());
    }

    public static boolean isHiragana(char c) {
        return 0x3041 <= c && c <= 0x3093;
    }

    public static boolean isKatakana(Character c) {
        if (c == null) return false;
        return isKatakana(c.charValue());
    }

    public static boolean isKatakana(char c) {
        return 0x30A1 <= c && c <= 0x30F4;
    }

}
