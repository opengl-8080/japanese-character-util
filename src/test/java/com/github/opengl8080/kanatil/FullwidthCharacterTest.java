package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class FullwidthCharacterTest {

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
