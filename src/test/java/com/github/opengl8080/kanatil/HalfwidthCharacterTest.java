package com.github.opengl8080.kanatil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class HalfwidthCharacterTest {
    
    
    public class 半角ｶﾅ小文字判定 {

        @Test
        public void 半角ｶﾅ小文字はtrue() {
            for (Character c : Characters.HALFWIDTH_LOWER_CHARACTER) {
                assertThatLowerCharacter(c, true);
            }
        }

        @Test
        public void 半角ｶﾅ通常文字はfalse() {
            for (Character c : Characters.HALFWIDTH_UPPER_CHARACTER) {
                assertThatLowerCharacter(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatLowerCharacter(null, false);
        }
        
        private void assertThatLowerCharacter(Character c, boolean expected) {
            assertThat(c + "", HalfwidthCharacter.isHalfwidthLowerCharacter(c), is(expected));
        }
    }
    
    public class 半角ｶﾅ文字_文字列判定 {

        @Test
        public void 半角ｶﾅ文字はtrue() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_CHARACTER, true);
        }

        @Test
        public void 半角ｶﾅ記号はfalse() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_SYMBOL, false);
        }
        
        private void assertThatHalfwidthCharacter(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(str, HalfwidthCharacter.isHalfwidthCharacter(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(HalfwidthCharacter.isHalfwidthCharacter(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(HalfwidthCharacter.isHalfwidthCharacter((String)null), is(false));
        }
    }
    
    public class 半角ｶﾅ文字判定 {

        @Test
        public void 半角ｶﾅ文字はtrue() {
            for (Character c : Characters.HALFWIDTH_CHARACTER) {
                assertThatCharacter(c, true);
            }
        }

        @Test
        public void 半角ｶﾅ記号はfalse() {
            for (Character c : Characters.HALFWIDTH_SYMBOL) {
                assertThatCharacter(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatCharacter(null, false);
        }
        
        private void assertThatCharacter(Character c, boolean expected) {
            assertThat(c + "", HalfwidthCharacter.isHalfwidthCharacter(c), is(expected));
        }
    }
    
    public class 半角ｶﾅ記号_文字列判定 {

        @Test
        public void 半角ｶﾅ記号はtrue() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_SYMBOL, true);
        }

        @Test
        public void 半角ｶﾅ文字はfalse() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_CHARACTER, false);
        }
        
        private void assertThatHalfwidthCharacter(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(str, HalfwidthCharacter.isHalfwidthSymbol(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(str, HalfwidthCharacter.isHalfwidthSymbol(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(HalfwidthCharacter.isHalfwidthSymbol((String)null), is(false));
        }
    }
    
    public class 半角ｶﾅ記号判定 {

        @Test
        public void 半角ｶﾅ記号はtrue() {
            for (Character c : Characters.HALFWIDTH_SYMBOL) {
                assertThatSymbol(c, true);
            }
        }

        @Test
        public void 半角ｶﾅ文字はfalse() {
            for (Character c : Characters.HALFWIDTH_CHARACTER) {
                assertThatSymbol(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatSymbol(null, false);
        }
        
        private void assertThatSymbol(Character c, boolean expected) {
            assertThat(c + "", HalfwidthCharacter.isHalfwidthSymbol(c), is(expected));
        }
    }
    
    public class 半角ｶﾅ文字種_文字列判定 {

        @Test
        public void 半角ｶﾅ文字種はtrue() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH, true);
        }

        @Test
        public void アスキー文字種はfalse() {
            assertThatHalfwidthCharacter(Characters.ASCII, false);
        }
        
        private void assertThatHalfwidthCharacter(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(str, HalfwidthCharacter.isHalfwidth(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(str, HalfwidthCharacter.isHalfwidth(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(HalfwidthCharacter.isHalfwidth((String)null), is(false));
        }
    }
    
    public class 半角ｶﾅ文字種判定 {

        @Test
        public void 半角ｶﾅ文字種はtrue() {
            for (Character c : Characters.HALFWIDTH_CHARACTER) {
                assertThatHalfwidth(c, true);
            }
        }
        
        @Test
        public void アスキー文字種はfalse() {
            for (Character c : Characters.ASCII) {
                assertThatHalfwidth(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatHalfwidth(null, false);
        }
        
        private void assertThatHalfwidth(Character c, boolean expected) {
            assertThat(c + "", HalfwidthCharacter.isHalfwidth(c), is(expected));
        }
    }
}
