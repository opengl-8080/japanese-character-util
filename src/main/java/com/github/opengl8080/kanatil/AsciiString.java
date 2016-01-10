package com.github.opengl8080.kanatil;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AsciiString {

    public static boolean anyOf(Character c, AsciiChar... chars) {
        /* 
         * 第一引数が char のメソッドはオーバーロードできない。
         * 何故か、メソッドの呼び出しが曖昧になる。
         * null を渡すことによるバグを無くすことを優先し、 char 型を受け取るメソッドは定義しない。
         */
        if (c == null) return false;
        
        for (AsciiChar ascii : chars) {
            if (c == ascii.getChar()) {
                return true;
            }
        }
        
        return false;
    }

    public static boolean anyOf(char c, List<AsciiChar> chars) {
        for (AsciiChar ascii : chars) {
            if (c == ascii.getChar()) {
                return true;
            }
        }
        
        return false;
    }

    public static boolean anyOf(Character c, List<AsciiChar> chars) {
        if (c == null) return false;
        return anyOf(c.charValue(), chars);
    }
    
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

    public static boolean composeOf(String string, AsciiChar... asciiCharacters) {
        if (Utils.isEmpty(string)
            || Utils.isEmpty(asciiCharacters)
            || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        return composeOf(string, AsciiChar.toCharArray(asciiCharacters));
    }

    public static boolean composeOf(String string, Collection<AsciiChar> asciiCharacters) {
        if (Utils.isEmpty(string)
            || Utils.isEmpty(asciiCharacters)
            || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        return composeOf(string, AsciiChar.toCharArray(asciiCharacters));
    }

    public static boolean composeOf(String string, Iterable<AsciiChar> asciiCharacters) {
        if (Utils.isEmpty(string)
            || Utils.isEmpty(asciiCharacters)
            || Utils.hasSurrogatePair(string)) {
            return false;
        }
        
        return composeOf(string, AsciiChar.toCharArray(asciiCharacters));
    }
    
    private static boolean composeOf(String string, char[] asciiCharacters) {
        Arrays.sort(asciiCharacters);
        
        for (char c : string.toCharArray()) {
            if (Arrays.binarySearch(asciiCharacters, c) == -1) {
                return false;
            }
        }
        
        return true;
    }

    public static boolean contains(String string, AsciiChar... asciiCharacters) {
        if (Utils.isEmpty(string) || Utils.isEmpty(asciiCharacters)) return false;

        return contains(string, AsciiChar.toCharArray(asciiCharacters));
    }

    public static boolean contains(String string, Collection<AsciiChar> asciiCharacters) {
        if (Utils.isEmpty(string) || Utils.isEmpty(asciiCharacters)) return false;
        
        return contains(string, AsciiChar.toCharArray(asciiCharacters));
    }

    public static boolean contains(String string, Iterable<AsciiChar> asciiCharacters) {
        if (Utils.isEmpty(string) || Utils.isEmpty(asciiCharacters)) return false;
        
        return contains(string, AsciiChar.toCharArray(asciiCharacters));
    }

    public static boolean contains(String string, char[] asciiCharacters) {
        for (char c : string.toCharArray()) {
            if (Arrays.binarySearch(asciiCharacters, c) != -1) {
                return true;
            }
        }
        
        return false;
    }

}
