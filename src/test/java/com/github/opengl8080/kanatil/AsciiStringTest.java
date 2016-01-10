package com.github.opengl8080.kanatil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class AsciiStringTest {
    
    public class 文字指定判定 {
        
        @Test
        public void 可変長引数指定_true() throws Exception {
            assertThat(AsciiString.anyOf('a', AsciiChar.a, AsciiChar.b, AsciiChar.c), is(true));
        }
        
        @Test
        public void 可変長引数指定_false() throws Exception {
            assertThat(AsciiString.anyOf('a', AsciiChar.A, AsciiChar.B, AsciiChar.C), is(false));
        }
        
        @Test
        public void 可変長引数指定_nullはfalse() throws Exception {
            assertThat(AsciiString.anyOf(null, AsciiChar.a, AsciiChar.b, AsciiChar.c), is(false));
        }
        
        @Test
        public void List指定_true() throws Exception {
            assertThat(AsciiString.anyOf('a', Arrays.asList(AsciiChar.a, AsciiChar.b, AsciiChar.c)), is(true));
        }
        
        @Test
        public void List指定_false() throws Exception {
            assertThat(AsciiString.anyOf('a', Arrays.asList(AsciiChar.A, AsciiChar.B, AsciiChar.C)), is(false));
        }
        
        @Test
        public void List指定_nullはfalse() throws Exception {
            assertThat(AsciiString.anyOf(null, Arrays.asList(AsciiChar.A, AsciiChar.B, AsciiChar.C)), is(false));
        }
    }
    
    public class 文字指定_完全一致判定_文字列 {
        
        public class 可変長引数指定 {
            
            @Test
            public void 指定した文字だけで構成されている場合はtrue() throws Exception {
                assertThat(AsciiString.composeOf("aabbcc", AsciiChar.a, AsciiChar.b, AsciiChar.c), is(true));
            }
            
            @Test
            public void 指定した文字以外が含まれる場合はfalse() throws Exception {
                assertThat(AsciiString.composeOf("AaBbCc", AsciiChar.a, AsciiChar.b, AsciiChar.c), is(false));
            }
            
            @Test
            public void サロゲートペア文字を含む場合はfalse() throws Exception {
                assertThat(AsciiString.composeOf("𩸽abc", AsciiChar.a, AsciiChar.b, AsciiChar.c), is(false));
            }
            
            @Test
            public void nullはfalse() throws Exception {
                assertThat(AsciiString.composeOf(null, AsciiChar.a, AsciiChar.b, AsciiChar.c), is(false));
            }
            
            @Test
            public void 空文字はfalse() throws Exception {
                assertThat(AsciiString.composeOf("", AsciiChar.a, AsciiChar.b, AsciiChar.c), is(false));
            }
        }
        
        public class Iterable指定 {
            
            private Iterable<AsciiChar> asciiCharList = Arrays.asList(AsciiChar.a, AsciiChar.b, AsciiChar.c);
            
            @Test
            public void 指定した文字だけで構成されている場合はtrue() throws Exception {
                assertThat(AsciiString.composeOf("aabbcc", asciiCharList), is(true));
            }
            
            @Test
            public void 指定した文字以外が含まれる場合はfalse() throws Exception {
                assertThat(AsciiString.composeOf("AaBbCc", asciiCharList), is(false));
            }
            
            @Test
            public void サロゲートペア文字を含む場合はfalse() throws Exception {
                assertThat(AsciiString.composeOf("𩸽abc", asciiCharList), is(false));
            }
            
            @Test
            public void nullはfalse() throws Exception {
                assertThat(AsciiString.composeOf(null, asciiCharList), is(false));
            }
            
            @Test
            public void 空文字はfalse() throws Exception {
                assertThat(AsciiString.composeOf("", asciiCharList), is(false));
            }
        }
        
        public class Collection指定 {
            
            private Collection<AsciiChar> asciiCharList = Arrays.asList(AsciiChar.a, AsciiChar.b, AsciiChar.c);
            
            @Test
            public void 指定した文字だけで構成されている場合はtrue() throws Exception {
                assertThat(AsciiString.composeOf("aabbcc", asciiCharList), is(true));
            }
            
            @Test
            public void 指定した文字以外が含まれる場合はfalse() throws Exception {
                assertThat(AsciiString.composeOf("AaBbCc", asciiCharList), is(false));
            }
            
            @Test
            public void サロゲートペア文字を含む場合はfalse() throws Exception {
                assertThat(AsciiString.composeOf("𩸽abc", asciiCharList), is(false));
            }
            
            @Test
            public void nullはfalse() throws Exception {
                assertThat(AsciiString.composeOf(null, asciiCharList), is(false));
            }
            
            @Test
            public void 空文字はfalse() throws Exception {
                assertThat(AsciiString.composeOf("", asciiCharList), is(false));
            }
        }
    }
    
    public class 文字指定_部分一致判定_文字列 {
        
        public class 可変長引数指定 {
            
            @Test
            public void 指定した文字だけで構成されている場合はtrue() throws Exception {
                assertThat(AsciiString.contains("aabbcc", AsciiChar.a, AsciiChar.b, AsciiChar.c), is(true));
            }
            
            @Test
            public void 指定した文字が含まれていれば_他の文字が含まれていてもtrue() throws Exception {
                assertThat(AsciiString.contains("ABCc", AsciiChar.a, AsciiChar.b, AsciiChar.c), is(true));
            }
            
            @Test
            public void 指定した文字が含まれていれば_サロゲートペア文字を含まれていてもtrue() throws Exception {
                assertThat(AsciiString.contains("𩸽abc", AsciiChar.a, AsciiChar.b, AsciiChar.c), is(true));
            }
            
            @Test
            public void 指定した文字が１つも含まれない場合はfalse() throws Exception {
                assertThat(AsciiString.contains("ABC", AsciiChar.a, AsciiChar.b, AsciiChar.c), is(false));
            }
            
            @Test
            public void nullはfalse() throws Exception {
                assertThat(AsciiString.contains(null, AsciiChar.a, AsciiChar.b, AsciiChar.c), is(false));
            }
            
            @Test
            public void 空文字はfalse() throws Exception {
                assertThat(AsciiString.contains("", AsciiChar.a, AsciiChar.b, AsciiChar.c), is(false));
            }
        }
        
        public class Iterable指定 {
            
            private Iterable<AsciiChar> asciiCharList = Arrays.asList(AsciiChar.a, AsciiChar.b, AsciiChar.c);

            @Test
            public void 指定した文字だけで構成されている場合はtrue() throws Exception {
                assertThat(AsciiString.contains("aabbcc", asciiCharList), is(true));
            }
            
            @Test
            public void 指定した文字が含まれていれば_他の文字が含まれていてもtrue() throws Exception {
                assertThat(AsciiString.contains("ABCc", asciiCharList), is(true));
            }
            
            @Test
            public void 指定した文字が含まれていれば_サロゲートペア文字を含まれていてもtrue() throws Exception {
                assertThat(AsciiString.contains("𩸽abc", asciiCharList), is(true));
            }
            
            @Test
            public void 指定した文字が１つも含まれない場合はfalse() throws Exception {
                assertThat(AsciiString.contains("ABC", asciiCharList), is(false));
            }
            
            @Test
            public void nullはfalse() throws Exception {
                assertThat(AsciiString.contains(null, asciiCharList), is(false));
            }
            
            @Test
            public void 空文字はfalse() throws Exception {
                assertThat(AsciiString.contains("", asciiCharList), is(false));
            }
        }
        
        public class Collection指定 {
            
            private Collection<AsciiChar> asciiCharList = Arrays.asList(AsciiChar.a, AsciiChar.b, AsciiChar.c);

            @Test
            public void 指定した文字だけで構成されている場合はtrue() throws Exception {
                assertThat(AsciiString.contains("aabbcc", asciiCharList), is(true));
            }
            
            @Test
            public void 指定した文字が含まれていれば_他の文字が含まれていてもtrue() throws Exception {
                assertThat(AsciiString.contains("ABCc", asciiCharList), is(true));
            }
            
            @Test
            public void 指定した文字が含まれていれば_サロゲートペア文字を含まれていてもtrue() throws Exception {
                assertThat(AsciiString.contains("𩸽abc", asciiCharList), is(true));
            }
            
            @Test
            public void 指定した文字が１つも含まれない場合はfalse() throws Exception {
                assertThat(AsciiString.contains("ABC", asciiCharList), is(false));
            }
            
            @Test
            public void nullはfalse() throws Exception {
                assertThat(AsciiString.contains(null, asciiCharList), is(false));
            }
            
            @Test
            public void 空文字はfalse() throws Exception {
                assertThat(AsciiString.contains("", asciiCharList), is(false));
            }
        }
    }
    
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
            assertThat(str, AsciiString.isAscii(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(AsciiString.isAscii(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(AsciiString.isAscii((String)null), is(false));
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
            assertThat(c + "", AsciiString.isAscii(c), is(expected));
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
            assertThat(str, AsciiString.isNumber(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "123\uD867\uDE3D456";
            assertThat(str, AsciiString.isNumber(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(AsciiString.isNumber((String)null), is(false));
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
            assertThat(AsciiString.isNumber(c), is(expected));
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
            assertThat(AsciiString.isAlphabet(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(AsciiString.isAlphabet(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(AsciiString.isAlphabet((String)null), is(false));
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
            assertThat(c + "", AsciiString.isAlphabet(c), is(expected));
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
            assertThat(AsciiString.isSymbol(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(AsciiString.isSymbol(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(AsciiString.isSymbol((String)null), is(false));
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
            assertThat(c + "", AsciiString.isSymbol(c), is(expected));
        }
    }
}
