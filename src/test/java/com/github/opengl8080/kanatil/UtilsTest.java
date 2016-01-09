package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class UtilsTest {

    public class isEmpty {
        
        @Test
        public void 空文字はtrue() throws Exception {
            assertThat(Utils.isEmpty("")).isTrue();
        }
        
        @Test
        public void 非空文字はfalse() throws Exception {
            assertThat(Utils.isEmpty("abc")).isFalse();
        }
        
        @Test
        public void nullはtrue() throws Exception {
            assertThat(Utils.isEmpty(null)).isTrue();
        }
    }

    public class hasSurrogatePair {
        
        @Test
        public void サロゲートペア文字を含む場合はtrue() throws Exception {
            assertThat(Utils.hasSurrogatePair("abc\uD867\uDE3Ddef")).isTrue();
        }
        
        @Test
        public void サロゲートペア文字を含まない場合はfalse() throws Exception {
            assertThat(Utils.hasSurrogatePair("abcdefあいうえお")).isFalse();
        }
        
        @Test
        public void nullはfalse() throws Exception {
            assertThat(Utils.hasSurrogatePair(null)).isFalse();
        }
    }
}
