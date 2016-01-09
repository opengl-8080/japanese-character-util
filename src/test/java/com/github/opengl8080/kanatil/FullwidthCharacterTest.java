package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class FullwidthCharacterTest {

    public class ひらがな文字列判定 {

        @Test
        public void ひらがなの場合はtrue() {
            assertThatHiragana(Characters.HIRAGANA).isTrue();
        }

        @Test
        public void カタカナの場合はfalse() {
            assertThatHiragana(Characters.KATAKANA).isFalse();
        }
        
        private AbstractBooleanAssert<?> assertThatHiragana(List<Character> chars) {
            String str = Characters.toString(chars);
            return assertThat(FullwidthCharacter.isHiragana(str)).as(str);
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(FullwidthCharacter.isHiragana(str)).isFalse();
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(FullwidthCharacter.isHiragana((String)null)).isFalse();
        }
    }
    
    public class ひらがな判定 {
        
        @Test
        public void ひらがなの場合はtrue() throws Exception {
            for (Character c : Characters.HIRAGANA) {
                assertThatHiragana(c).isTrue();
            }
        }
        @Test
        public void カタカナの場合はfalse() throws Exception {
            for (Character c : Characters.KATAKANA) {
                assertThatHiragana(c).isFalse();
            }
        }

        @Test
        public void nullはfalse() {
            assertThatHiragana(null).isFalse();
        }
        
        private AbstractBooleanAssert<?> assertThatHiragana(Character c) {
            return assertThat(FullwidthCharacter.isHiragana(c)).as(c + "");
        }
    }
    
    public class カタカナ文字列判定 {

        @Test
        public void カタカナの場合はtrue() {
            assertThatHiragana(Characters.KATAKANA).isTrue();
        }

        @Test
        public void ひらがなの場合はfalse() {
            assertThatHiragana(Characters.HIRAGANA).isFalse();
        }
        
        private AbstractBooleanAssert<?> assertThatHiragana(List<Character> chars) {
            String str = Characters.toString(chars);
            return assertThat(FullwidthCharacter.isKatakana(str)).as(str);
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(FullwidthCharacter.isKatakana(str)).isFalse();
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(FullwidthCharacter.isKatakana((String)null)).isFalse();
        }
    }

    public class カタカナ判定 {

        @Test
        public void カタカナの場合はtrue() throws Exception {
            for (Character c : Characters.KATAKANA) {
                assertThatKatakana(c).isTrue();
            }
        }
        
        @Test
        public void ひらがなの場合はfalse() throws Exception {
            for (Character c : Characters.HIRAGANA) {
                assertThatKatakana(c).isFalse();
            }
        }

        @Test
        public void nullはfalse() {
            assertThatKatakana(null).isFalse();
        }
        
        private AbstractBooleanAssert<?> assertThatKatakana(Character c) {
            return assertThat(FullwidthCharacter.isKatakana(c)).as(c + "");
        }
    }
    
}
