package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class AsciiCharacterTest {
    
    public class アスキー文字列判定 {

        @Test
        public void アスキー文字はtrue() {
            assertThatAscii(Characters.ASCII).isTrue();
        }

        @Test
        public void 半角ｶﾅはfalse() {
            assertThatAscii(Characters.HALFWIDTH).isFalse();
        }
        
        private AbstractBooleanAssert<?> assertThatAscii(List<Character> chars) {
            String str = Characters.toString(chars);
            return assertThat(AsciiCharacter.isAscii(str)).as(str);
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef"; // abc𩸽def
            assertThat(AsciiCharacter.isAscii(str)).isFalse();
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(AsciiCharacter.isAscii(null)).isFalse();
        }
    }
    
    public class アスキー文字判定 {

        @Test
        public void アスキー文字はtrue() {
            for (char c : Characters.ASCII) {
                assertThatAscii(c).isTrue();
            }
        }

        @Test
        public void 半角ｶﾅはfalse() {
            for (char c : Characters.HALFWIDTH) {
                assertThatAscii(c).isFalse();
            }
        }
        
        private AbstractBooleanAssert<?> assertThatAscii(char c) {
            return assertThat(AsciiCharacter.isAscii(c)).as(c + "");
        }
    }

    public class 数字判定 {

        @Test
        public void 数字はtrue() {
            for (char c : Characters.HALF_NUMBER) {
                assertThatNumber(c).isTrue();
            }
        }

        @Test
        public void アルファベットはfalse() {
            for (char c : Characters.ALPHABET) {
                assertThatNumber(c).isFalse();
            }
        }
        
        private AbstractBooleanAssert<?> assertThatNumber(char c) {
            return assertThat(AsciiCharacter.isNumber(c)).as(c + "");
        }
    }

    public class アルファベット判定 {

        @Test
        public void アルファベットはtrue() {
            for (char c : Characters.ALPHABET) {
                assertThatAlphabet(c).isTrue();
            }
        }

        @Test
        public void 記号はfalse() {
            for (char c : Characters.HALF_SYMBOL) {
                assertThatAlphabet(c).isFalse();
            }
        }
        
        private AbstractBooleanAssert<?> assertThatAlphabet(char c) {
            return assertThat(AsciiCharacter.isAlphabet(c)).as(c + "");
        }
    }

    public class 記号判定 {

        @Test
        public void 記号はtrue() {
            for (char c : Characters.HALF_SYMBOL) {
                assertThatSymbol(c).isTrue();
            }
        }

        @Test
        public void アルファベットはfalse() {
            for (char c : Characters.ALPHABET) {
                assertThatSymbol(c).isFalse();
            }
        }
        
        private AbstractBooleanAssert<?> assertThatSymbol(char c) {
            return assertThat(AsciiCharacter.isSymbol(c)).as(c + "");
        }
    }
}
