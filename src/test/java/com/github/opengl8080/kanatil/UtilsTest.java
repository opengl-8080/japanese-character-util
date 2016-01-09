package com.github.opengl8080.kanatil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class UtilsTest {

    public class isEmpty {
        
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

    public class hasSurrogatePair {
        
        @Test
        public void サロゲートペア文字を含む場合はtrue() throws Exception {
            assertThatHasSurrogatePair("abc\uD867\uDE3Ddef", true);
        }
        
        @Test
        public void サロゲートペア文字を含まない場合はfalse() throws Exception {
            assertThatHasSurrogatePair("abcdefあいうえお", false);
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
