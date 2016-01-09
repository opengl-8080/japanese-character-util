package com.github.opengl8080.kanatil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class AsciiCharacterTest {
    
    public class アスキー文字列判定 {
        
        @Test
        public void アスキー文字はtrue() {
            assertThatAscii(Characters.ASCII, true);
        }

        @Test
        public void 半角ｶﾅはfalse() {
            assertThatAscii(Characters.HALFWIDTH, false);
        }
        
        private void assertThatAscii(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(str, AsciiCharacter.isAscii(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(AsciiCharacter.isAscii(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(AsciiCharacter.isAscii((String)null), is(false));
        }
    }
    
    public class アスキー文字判定 {

        @Test
        public void アスキー文字はtrue() {
            for (Character c : Characters.ASCII) {
                assertThatAscii(c, true);
            }
        }

        @Test
        public void 半角ｶﾅはfalse() {
            for (Character c : Characters.HALFWIDTH) {
                assertThatAscii(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatAscii(null, false);
        }
        
        private void assertThatAscii(Character c, boolean expected) {
            assertThat(c + "", AsciiCharacter.isAscii(c), is(expected));
        }
    }
    
    public class 数値文字列判定 {

        @Test
        public void 数値はtrue() {
            assertThatNumber(Characters.HALF_NUMBER, true);
        }

        @Test
        public void アルファベットはfalse() {
            assertThatNumber(Characters.ALPHABET, false);
        }
        
        private void assertThatNumber(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(str, AsciiCharacter.isNumber(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "123\uD867\uDE3D456";
            assertThat(str, AsciiCharacter.isNumber(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(AsciiCharacter.isNumber((String)null), is(false));
        }
    }

    public class 数字判定 {

        @Test
        public void 数字はtrue() {
            for (Character c : Characters.HALF_NUMBER) {
                assertThatNumber(c, true);
            }
        }

        @Test
        public void アルファベットはfalse() {
            for (Character c : Characters.ALPHABET) {
                assertThatNumber(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatNumber(null, false);
        }
        
        private void assertThatNumber(Character c, boolean expected) {
            assertThat(AsciiCharacter.isNumber(c), is(expected));
        }
    }
    
    public class アルファベット文字列判定 {

        @Test
        public void アルファベットはtrue() {
            assertThatAlphabet(Characters.ALPHABET, true);
        }

        @Test
        public void 記号はfalse() {
            assertThatAlphabet(Characters.HALF_SYMBOL, false);
        }
        
        private void assertThatAlphabet(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(AsciiCharacter.isAlphabet(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(AsciiCharacter.isAlphabet(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(AsciiCharacter.isAlphabet((String)null), is(false));
        }
    }

    public class アルファベット判定 {

        @Test
        public void アルファベットはtrue() {
            for (Character c : Characters.ALPHABET) {
                assertThatAlphabet(c, true);
            }
        }

        @Test
        public void 記号はfalse() {
            for (Character c : Characters.HALF_SYMBOL) {
                assertThatAlphabet(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatAlphabet(null, false);
        }
        
        private void assertThatAlphabet(Character c, boolean expected) {
            assertThat(c + "", AsciiCharacter.isAlphabet(c), is(expected));
        }
    }
    
    public class 記号文字列判定 {

        @Test
        public void 記号はtrue() {
            assertThatSymbol(Characters.HALF_SYMBOL, true);
        }

        @Test
        public void アルファベットはfalse() {
            assertThatSymbol(Characters.ALPHABET, false);
        }
        
        private void assertThatSymbol(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(AsciiCharacter.isSymbol(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(AsciiCharacter.isSymbol(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(AsciiCharacter.isSymbol((String)null), is(false));
        }
    }

    public class 記号判定 {

        @Test
        public void 記号はtrue() {
            for (Character c : Characters.HALF_SYMBOL) {
                assertThatSymbol(c, true);
            }
        }

        @Test
        public void アルファベットはfalse() {
            for (Character c : Characters.ALPHABET) {
                assertThatSymbol(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatSymbol(null, false);
        }
        
        
        private void assertThatSymbol(Character c, boolean expected) {
            assertThat(c + "", AsciiCharacter.isSymbol(c), is(expected));
        }
    }
}
