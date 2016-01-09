package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class UtilsTest {

    public class isEmpty {
        
        @Test
        public void 空文字はtrue() throws Exception {
            assertThatIsEmpty("").isTrue();
        }
        
        @Test
        public void 非空文字はfalse() throws Exception {
            assertThatIsEmpty("abc").isFalse();
        }
        
        @Test
        public void nullはtrue() throws Exception {
            assertThatIsEmpty(null).isTrue();
        }
        
        private AbstractBooleanAssert<?> assertThatIsEmpty(String string) {
            return assertThat(Utils.isEmpty(string));
        }
    }

    public class hasSurrogatePair {
        
        @Test
        public void サロゲートペア文字を含む場合はtrue() throws Exception {
            assertThatHasSurrogatePair("abc\uD867\uDE3Ddef").isTrue();
        }
        
        @Test
        public void サロゲートペア文字を含まない場合はfalse() throws Exception {
            assertThatHasSurrogatePair("abcdefあいうえお").isFalse();
        }
        
        @Test
        public void nullはfalse() throws Exception {
            assertThatHasSurrogatePair(null).isFalse();
        }
        
        private AbstractBooleanAssert<?> assertThatHasSurrogatePair(String string) {
            return assertThat(Utils.hasSurrogatePair(string));
        }
    }
}
