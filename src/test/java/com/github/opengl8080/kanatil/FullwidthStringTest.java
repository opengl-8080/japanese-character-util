package com.github.opengl8080.kanatil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class FullwidthStringTest {

    public class ひらがな文字列判定 {

        @Test
        public void ひらがなの場合はtrue() {
            assertThatHiragana(Characters.HIRAGANA, true);
        }

        @Test
        public void カタカナの場合はfalse() {
            assertThatHiragana(Characters.KATAKANA, false);
        }
        
        private void assertThatHiragana(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(str, FullwidthString.isHiragana(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(FullwidthString.isHiragana(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(FullwidthString.isHiragana((String)null), is(false));
        }
    }
    
    public class ひらがな判定 {
        
        @Test
        public void ひらがなの場合はtrue() throws Exception {
            for (Character c : Characters.HIRAGANA) {
                assertThatHiragana(c, true);
            }
        }
        @Test
        public void カタカナの場合はfalse() throws Exception {
            for (Character c : Characters.KATAKANA) {
                assertThatHiragana(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatHiragana(null, false);
        }
        
        private void assertThatHiragana(Character c, boolean expected) {
            assertThat(c + "", FullwidthString.isHiragana(c), is(expected));
        }
    }
    
    public class カタカナ文字列判定 {

        @Test
        public void カタカナの場合はtrue() {
            assertThatHiragana(Characters.KATAKANA, true);
        }

        @Test
        public void ひらがなの場合はfalse() {
            assertThatHiragana(Characters.HIRAGANA, false);
        }
        
        private void assertThatHiragana(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(str, FullwidthString.isKatakana(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(FullwidthString.isKatakana(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(FullwidthString.isKatakana((String)null), is(false));
        }
    }

    public class カタカナ判定 {

        @Test
        public void カタカナの場合はtrue() throws Exception {
            for (Character c : Characters.KATAKANA) {
                assertThatKatakana(c, true);
            }
        }
        
        @Test
        public void ひらがなの場合はfalse() throws Exception {
            for (Character c : Characters.HIRAGANA) {
                assertThatKatakana(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatKatakana(null, false);
        }
        
        private void assertThatKatakana(Character c, boolean expected) {
            assertThat(c + "", FullwidthString.isKatakana(c), is(expected));
        }
    }
    
}
