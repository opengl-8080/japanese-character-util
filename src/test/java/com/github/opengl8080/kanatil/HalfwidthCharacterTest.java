package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class HalfwidthCharacterTest {
    public class 半角ｶﾅ小文字判定 {

        @Test
        public void 半角ｶﾅ小文字はtrue() {
            for (char c : Characters.HALFWIDTH_LOWER_CHARACTER) {
                assertThat(HalfwidthCharacter.isHalfwidthLowerCharacter(c))
                    .as(c + "")
                    .isTrue();
            }
        }

        @Test
        public void 半角ｶﾅ通常文字はfalse() {
            for (char c : Characters.HALFWIDTH_UPPER_CHARACTER) {
                assertThat(HalfwidthCharacter.isHalfwidthLowerCharacter(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
    
    public class 半角ｶﾅ文字判定 {

        @Test
        public void 半角ｶﾅ文字はtrue() {
            for (char c : Characters.HALFWIDTH_CHARACTER) {
                assertThat(HalfwidthCharacter.isHalfwidthCharacter(c))
                    .as(c + "")
                    .isTrue();
            }
        }

        @Test
        public void 半角ｶﾅ記号はfalse() {
            for (char c : Characters.HALFWIDTH_SYMBOL) {
                assertThat(HalfwidthCharacter.isHalfwidthCharacter(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
    
    public class 半角ｶﾅ記号判定 {

        @Test
        public void 半角ｶﾅ記号はtrue() {
            for (char c : Characters.HALFWIDTH_SYMBOL) {
                assertThat(HalfwidthCharacter.isHalfwidthSymbol(c))
                    .as(c + "")
                    .isTrue();
            }
        }

        @Test
        public void 半角ｶﾅ文字はfalse() {
            for (char c : Characters.HALFWIDTH_CHARACTER) {
                assertThat(HalfwidthCharacter.isHalfwidthSymbol(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
    
    public class 半角ｶﾅ文字種判定 {

        @Test
        public void 半角ｶﾅ文字種はtrue() {
            for (char c : Characters.HALFWIDTH_CHARACTER) {
                assertThat(HalfwidthCharacter.isHalfwidth(c))
                    .as(c + "")
                    .isTrue();
            }
        }
        
        @Test
        public void アスキー文字種はfalse() {
            for (char c : Characters.ASCII) {
                assertThat(HalfwidthCharacter.isHalfwidth(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
}
