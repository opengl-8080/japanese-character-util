package com.github.opengl8080.kanatil;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Utils {
    
    private Utils() {}
    
    public static int hashCode(Object... values) {
        return Arrays.hashCode(values);
    }

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
        if (string == null || string.isEmpty()) return false;
        
        int length = string.length();
        int codePointLength = string.codePointCount(0, length);
        
        return length != codePointLength;
    }

    public static <K, V> Map<V, K> reverse(Map<K, V> map) {
        Map<V, K> reverse = new HashMap<V, K>();
        if (map == null) {
            return reverse;
        }
        
        for (Entry<K, V> entry : map.entrySet()) {
            reverse.put(entry.getValue(), entry.getKey());
        }
        
        return reverse;
    }
}
