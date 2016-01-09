package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class HalfwidthCharacterTest {
    
    
    public class 半角ｶﾅ小文字判定 {

        @Test
        public void 半角ｶﾅ小文字はtrue() {
            for (char c : Characters.HALFWIDTH_LOWER_CHARACTER) {
                assertThatLowerCharacter(c).isTrue();
            }
        }

        @Test
        public void 半角ｶﾅ通常文字はfalse() {
            for (char c : Characters.HALFWIDTH_UPPER_CHARACTER) {
                assertThatLowerCharacter(c).isFalse();
            }
        }
        
        private AbstractBooleanAssert<?> assertThatLowerCharacter(Character c) {
            return assertThat(HalfwidthCharacter.isHalfwidthLowerCharacter(c)).as(c + "");
        }
    }
    
    public class 半角ｶﾅ文字_文字列判定 {

        @Test
        public void 半角ｶﾅ文字はtrue() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_CHARACTER).isTrue();
        }

        @Test
        public void 半角ｶﾅ記号はfalse() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_SYMBOL).isFalse();
        }
        
        private AbstractBooleanAssert<?> assertThatHalfwidthCharacter(List<Character> chars) {
            String str = Characters.toString(chars);
            return assertThat(HalfwidthCharacter.isHalfwidthCharacter(str)).as(str);
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(HalfwidthCharacter.isHalfwidthCharacter(str)).isFalse();
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(HalfwidthCharacter.isHalfwidthCharacter((String)null)).isFalse();
        }
    }
    
    public class 半角ｶﾅ文字判定 {

        @Test
        public void 半角ｶﾅ文字はtrue() {
            for (char c : Characters.HALFWIDTH_CHARACTER) {
                assertThatCharacter(c).isTrue();
            }
        }

        @Test
        public void 半角ｶﾅ記号はfalse() {
            for (char c : Characters.HALFWIDTH_SYMBOL) {
                assertThatCharacter(c).isFalse();
            }
        }
        
        private AbstractBooleanAssert<?> assertThatCharacter(Character c) {
            return assertThat(HalfwidthCharacter.isHalfwidthCharacter(c)).as(c + "");
        }
    }
    
    public class 半角ｶﾅ記号_文字列判定 {

        @Test
        public void 半角ｶﾅ記号はtrue() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_SYMBOL).isTrue();
        }

        @Test
        public void 半角ｶﾅ文字はfalse() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_CHARACTER).isFalse();
        }
        
        private AbstractBooleanAssert<?> assertThatHalfwidthCharacter(List<Character> chars) {
            String str = Characters.toString(chars);
            return assertThat(HalfwidthCharacter.isHalfwidthSymbol(str)).as(str);
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(HalfwidthCharacter.isHalfwidthSymbol(str)).isFalse();
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(HalfwidthCharacter.isHalfwidthSymbol((String)null)).isFalse();
        }
    }
    
    public class 半角ｶﾅ記号判定 {

        @Test
        public void 半角ｶﾅ記号はtrue() {
            for (char c : Characters.HALFWIDTH_SYMBOL) {
                assertThatSymbol(c).isTrue();
            }
        }

        @Test
        public void 半角ｶﾅ文字はfalse() {
            for (char c : Characters.HALFWIDTH_CHARACTER) {
                assertThatSymbol(c).isFalse();
            }
        }
        
        private AbstractBooleanAssert<?> assertThatSymbol(Character c) {
            return assertThat(HalfwidthCharacter.isHalfwidthSymbol(c)).as(c + "");
        }
    }
    
    public class 半角ｶﾅ文字種_文字列判定 {

        @Test
        public void 半角ｶﾅ文字種はtrue() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH).isTrue();
        }

        @Test
        public void アスキー文字種はfalse() {
            assertThatHalfwidthCharacter(Characters.ASCII).isFalse();
        }
        
        private AbstractBooleanAssert<?> assertThatHalfwidthCharacter(List<Character> chars) {
            String str = Characters.toString(chars);
            return assertThat(HalfwidthCharacter.isHalfwidth(str)).as(str);
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(HalfwidthCharacter.isHalfwidth(str)).isFalse();
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(HalfwidthCharacter.isHalfwidth((String)null)).isFalse();
        }
    }
    
    public class 半角ｶﾅ文字種判定 {

        @Test
        public void 半角ｶﾅ文字種はtrue() {
            for (char c : Characters.HALFWIDTH_CHARACTER) {
                assertThatHalfwidth(c).isTrue();
            }
        }
        
        @Test
        public void アスキー文字種はfalse() {
            for (char c : Characters.ASCII) {
                assertThatHalfwidth(c).isFalse();
            }
        }
        
        private AbstractBooleanAssert<?> assertThatHalfwidth(Character c) {
            return assertThat(HalfwidthCharacter.isHalfwidth(c)).as(c + "");
        }
    }
}
