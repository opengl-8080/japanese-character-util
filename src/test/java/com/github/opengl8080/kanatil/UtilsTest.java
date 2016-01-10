package com.github.opengl8080.kanatil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class UtilsTest {

    public class Mapのリバース {
        
        @Test
        public void 空文字はtrue() throws Exception {
            // setup
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("foo", 10);
            map.put("bar", 20);
            
            Map<Integer, String> expected = new HashMap<Integer, String>();
            expected.put(10, "foo");
            expected.put(20, "bar");
            
            // exercise
            assertThatReverse(map, expected);
        }
        
        @Test
        public void nullを渡すと空のMapが返ってくる() throws Exception {
            assertThatReverse(null, new HashMap<Integer, String>());
        }
        
        public <K, V> void assertThatReverse(Map<K, V> map, Map<V, K> expected) throws Exception {
            // exercise
            Map<V, K> actual = Utils.reverse(map);
            
            // verify
            assertThat(actual, is(expected));
        }
    }
    
    public class 文字列の空判定 {
        
        @Test
        public void 空文字はtrue() throws Exception {
            assertThatIsEmpty("", true);
        }
        
        @Test
        public void 非空文字はfalse() throws Exception {
            assertThatIsEmpty("abc", false);
        }
        
        @Test
        public void nullはtrue() throws Exception {
            assertThatIsEmpty(null, true);
        }
        
        private void assertThatIsEmpty(String string, boolean expected) {
            assertThat(Utils.isEmpty(string), is(expected));
        }
    }

    public class 配列の空判定 {
        
        @Test
        public void 空はtrue() throws Exception {
            assertThatIsEmpty(new Object[0], true);
        }
        
        @Test
        public void nullはtrue() throws Exception {
            assertThatIsEmpty(null, true);
        }
        
        @Test
        public void 非空はfalse() throws Exception {
            assertThatIsEmpty(new Object[] {"a"}, false);
        }
        
        private void assertThatIsEmpty(Object[] array, boolean expected) {
            assertThat(Utils.isEmpty(array), is(expected));
        }
    }

    public class Iterableの空判定 {
        
        @Test
        public void 空はtrue() throws Exception {
            assertThatIsEmpty(Collections.emptyList(), true);
        }
        
        @Test
        public void nullはtrue() throws Exception {
            assertThatIsEmpty(null, true);
        }
        
        @Test
        public void 非空はfalse() throws Exception {
            assertThatIsEmpty(Arrays.asList(10), false);
        }
        
        private void assertThatIsEmpty(Iterable<?> iterable, boolean expected) {
            assertThat(Utils.isEmpty(iterable), is(expected));
        }
    }

    public class Collectionの空判定 {
        
        @Test
        public void 空はtrue() throws Exception {
            assertThatIsEmpty(Collections.emptyList(), true);
        }
        
        @Test
        public void nullはtrue() throws Exception {
            assertThatIsEmpty(null, true);
        }
        
        @Test
        public void 非空はfalse() throws Exception {
            assertThatIsEmpty(Arrays.asList(10), false);
        }
        
        private void assertThatIsEmpty(Collection<?> collection, boolean expected) {
            assertThat(Utils.isEmpty(collection), is(expected));
        }
    }

    public class hasSurrogatePair {
        
        @Test
        public void サロゲートペア文字を含む場合はtrue() throws Exception {
            assertThatHasSurrogatePair("abc𩸽def", true);
        }
        
        @Test
        public void サロゲートペア文字を含まない場合はfalse() throws Exception {
            assertThatHasSurrogatePair("abcdefあいうえお", false);
        }
        
        @Test
        public void 空文字はfalse() throws Exception {
            assertThatHasSurrogatePair("", false);
        }
        
        @Test
        public void nullはfalse() throws Exception {
            assertThatHasSurrogatePair(null, false);
        }
        
        private void assertThatHasSurrogatePair(String string, boolean expected) {
            assertThat(Utils.hasSurrogatePair(string), is(expected));
        }
    }
}
