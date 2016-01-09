package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class AsciiCharacterTest {
    
    public class アスキー文字判定 {

        @Test
        public void アスキー文字はtrue() {
            for (char c : Characters.ASCII) {
                assertThat(AsciiCharacter.isAscii(c))
                    .as(c + "")
                    .isTrue();
            }
        }

        @Test
        public void 半角ｶﾅはfalse() {
            for (char c : Characters.HALFWIDTH) {
                assertThat(AsciiCharacter.isAscii(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }

    public class 数字判定 {

        @Test
        public void 数字はtrue() {
            for (char c : Characters.HALF_NUMBER) {
                assertThat(AsciiCharacter.isNumber(c))
                    .as(c + "")
                    .isTrue();
            }
        }

        @Test
        public void アルファベットはfalse() {
            for (char c : Characters.ALPHABET) {
                assertThat(AsciiCharacter.isNumber(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }

    public class アルファベット判定 {

        @Test
        public void アルファベットはtrue() {
            for (char c : Characters.ALPHABET) {
                assertThat(AsciiCharacter.isAlphabet(c))
                    .as(c + "")
                    .isTrue();
            }
        }

        @Test
        public void 記号はfalse() {
            for (char c : Characters.HALF_SYMBOL) {
                assertThat(AsciiCharacter.isAlphabet(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }

    public class 記号判定 {

        @Test
        public void 記号はtrue() {
            for (char c : Characters.HALF_SYMBOL) {
                assertThat(AsciiCharacter.isSymbol(c))
                    .as(c + "")
                    .isTrue();
            }
        }

        @Test
        public void アルファベットはfalse() {
            for (char c : Characters.ALPHABET) {
                assertThat(AsciiCharacter.isSymbol(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
}
