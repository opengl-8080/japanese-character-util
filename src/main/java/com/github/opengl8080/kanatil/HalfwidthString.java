package com.github.opengl8080.kanatil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HalfwidthString {
    
    private static final HalfwidthString EMPTY = new HalfwidthString("");
    private static final Map<Character, Character> UPPER_TO_LOWER_MAP;
    private static final Map<Character, Character> LOWER_TO_UPPER_MAP;
    
    static {
        Map<Character, Character> map = new HashMap<Character, Character>();
        
        map.put('ｱ', 'ｧ');
        map.put('ｲ', 'ｨ');
        map.put('ｳ', 'ｩ');
        map.put('ｴ', 'ｪ');
        map.put('ｵ', 'ｫ');
        map.put('ﾂ', 'ｯ');
        map.put('ﾔ', 'ｬ');
        map.put('ﾕ', 'ｭ');
        map.put('ﾖ', 'ｮ');
        
        UPPER_TO_LOWER_MAP = Collections.unmodifiableMap(map);
        LOWER_TO_UPPER_MAP = Collections.unmodifiableMap(Utils.reverse(map));
    }
    
    private final String text;

    public HalfwidthString(String text) {
        if (Utils.isEmpty(text)) {
            this.text = "";
        } else {
            if (!isHalfwidth(text)) {
                throw new IllegalCharacterException("半角ｶﾅ以外の文字が含まれます : " + text);
            }
            this.text = text;
        }
    }
    
    @Override
    public String toString() {
        return this.text;
    }

    public static boolean isHalfwidthSymbol(Character c) {
        if (c == null) return false;
        return isHalfwidthSymbol(c.charValue());
    }

    public static boolean isHalfwidthSymbol(char c) {
        return ('\uFF61' <= c && c <= '\uFF65')
                || ('\uFF9E' <= c && c <= '\uFF9F')
                || '\uFF70' == c;
    }

    public static boolean isHalfwidthCharacter(Character c) {
        if (c == null) return false;
        return isHalfwidthCharacter(c.charValue());
    }

    public static boolean isHalfwidthCharacter(char c) {
        return '\uFF66' == c
                || isHalfwidthLowerCharacter(c)
                || ('\uFF71' <= c && c <= '\uFF9D');
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

    public boolean isSymbol() {
        return isHalfwidthSymbol(this.text);
    }

    public boolean isCharacter() {
        return isHalfwidthCharacter(this.text);
    }

    public boolean isEmpty() {
        return this.text.isEmpty();
    }

    public int length() {
        return this.text.length();
    }

    public HalfwidthString toLowerCase() {
        return this.mapping(UPPER_TO_LOWER_MAP);
    }

    public HalfwidthString toUpperCase() {
        return this.mapping(LOWER_TO_UPPER_MAP);
    }
    
    private HalfwidthString mapping(Map<Character, Character> map) {
        if (this.isEmpty()) {
            return EMPTY;
        }
        
        StringBuilder sb = new StringBuilder(this.text.length());
        
        for (char c : this.text.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                sb.append(c);
            }
        }
        
        return new HalfwidthString(sb.toString());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof HalfwidthString)) return false;
        
        HalfwidthString other = (HalfwidthString)obj;
        
        return this.text.equals(other.text);
    }
    
    @Override
    public int hashCode() {
        return Utils.hashCode(this.text);
    }
}
