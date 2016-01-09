package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class FullwidthCharacterTest {

    public class ひらがな判定 {
        
        @Test
        public void ひらがなの場合はtrue() throws Exception {
            for (char c : Characters.HIRAGANA) {
                assertThat(FullwidthCharacter.isHiragana(c))
                    .as(c + "")
                    .isTrue();
            }
        }
        @Test
        public void カタカナの場合はfalse() throws Exception {
            for (char c : Characters.KATAKANA) {
                assertThat(FullwidthCharacter.isHiragana(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }

    public class カタカナ判定 {

        @Test
        public void カタカナの場合はtrue() throws Exception {
            for (char c : Characters.KATAKANA) {
                assertThat(FullwidthCharacter.isKatakana(c))
                    .as(c + "")
                    .isTrue();
            }
        }
        @Test
        public void ひらがなの場合はfalse() throws Exception {
            for (char c : Characters.HIRAGANA) {
                assertThat(FullwidthCharacter.isKatakana(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
    
}
