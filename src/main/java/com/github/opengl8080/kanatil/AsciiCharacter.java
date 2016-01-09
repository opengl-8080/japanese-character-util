package com.github.opengl8080.kanatil;

public class AsciiCharacter {

    public static boolean isAscii(char c) {
        return isNumber(c)
                || isAlphabet(c)
                || isSymbol(c);
    }

    public static boolean isNumber(char c) {
        return 0x0030 <= c && c <= 0x0039;
    }

    public static boolean isAlphabet(char c) {
        return (0x0041 <= c && c <= 0x005A)
                || (0x0061 <= c && c <= 0x007A);
    }

    public static boolean isSymbol(char c) {
        return (0x0020 <= c && c <= 0x002F)
                || (0x003A <= c && c <= 0x0040)
                || (0x005B <= c && c <= 0x0060)
                || (0x007B <= c && c <= 0x007E);
    }

}
