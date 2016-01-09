package com.github.opengl8080.kanatil;

public class AsciiCharacter {

    public static boolean isAscii(Character c) {
        if (c == null) return false;
        return isAscii(c.charValue());
    }

    public static boolean isAscii(char c) {
        return isNumber(c)
                || isAlphabet(c)
                || isSymbol(c);
    }

    public static boolean isNumber(Character c) {
        if (c == null) return false;
        return isNumber(c.charValue());
    }

    public static boolean isNumber(char c) {
        return 0x0030 <= c && c <= 0x0039;
    }

    public static boolean isAlphabet(Character c) {
        if (c == null) return false;
        return isAlphabet(c.charValue());
    }

    public static boolean isAlphabet(char c) {
        return (0x0041 <= c && c <= 0x005A)
                || (0x0061 <= c && c <= 0x007A);
    }

    public static boolean isSymbol(Character c) {
        if (c == null) return false;
        return isSymbol(c.charValue());
    }

    public static boolean isSymbol(char c) {
        return (0x0020 <= c && c <= 0x002F)
                || (0x003A <= c && c <= 0x0040)
                || (0x005B <= c && c <= 0x0060)
                || (0x007B <= c && c <= 0x007E);
    }

    public static boolean isAscii(String string) {
        if (Utils.isEmpty(string) || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        for (char c : string.toCharArray()) {
            if (!isAscii(c)) {
                return false;
            }
        }
        
        return true;
    }

    public static boolean isNumber(String string) {
        if (Utils.isEmpty(string) || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        for (char c : string.toCharArray()) {
            if (!isNumber(c)) {
                return false;
            }
        }
        
        return true;
    }

    public static boolean isAlphabet(String string) {
        if (Utils.isEmpty(string) || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        for (char c : string.toCharArray()) {
            if (!isAlphabet(c)) {
                return false;
            }
        }
        
        return true;
    }

    public static boolean isSymbol(String string) {
        if (Utils.isEmpty(string) || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        for (char c : string.toCharArray()) {
            if (!isSymbol(c)) {
                return false;
            }
        }
        
        return true;
    }

}
