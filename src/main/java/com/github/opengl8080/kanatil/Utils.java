package com.github.opengl8080.kanatil;

import java.util.Collection;

public class Utils {
    
    private Utils() {}

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        return iterable == null || !iterable.iterator().hasNext();
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean hasSurrogatePair(String string) {
        if (string == null) return false;
        
        int length = string.length();
        int codePointLength = string.codePointCount(0, length);
        
        return length != codePointLength;
    }
}
