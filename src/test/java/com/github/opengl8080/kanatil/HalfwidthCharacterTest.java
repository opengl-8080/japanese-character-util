package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class HalfwidthCharacterTest {

    /**半角ｶﾅ記号*/
    private static List<Character> kanaSymbols = Arrays.asList('ﾞ', 'ﾟ', '｡', '｢', '｣', '､', '･', 'ｰ');
    /**半角ｶﾅ通常文字*/
    private static List<Character> kanaUpperCharacters = Arrays.asList(
        'ｱ', 'ｲ', 'ｳ', 'ｴ', 'ｵ',
        'ｶ', 'ｷ', 'ｸ', 'ｹ', 'ｺ',
        'ｻ', 'ｼ', 'ｽ', 'ｾ', 'ｿ',
        'ﾀ', 'ﾁ', 'ﾂ', 'ﾃ', 'ﾄ',
        'ﾅ', 'ﾆ', 'ﾇ', 'ﾈ', 'ﾉ',
        'ﾊ', 'ﾋ', 'ﾌ', 'ﾍ', 'ﾎ',
        'ﾏ', 'ﾐ', 'ﾑ', 'ﾒ', 'ﾓ',
        'ﾔ', 'ﾕ', 'ﾖ',
        'ﾗ', 'ﾘ', 'ﾙ', 'ﾚ', 'ﾛ',
        'ﾜ', 'ｦ', 'ﾝ'
    );
    /**半角ｶﾅ小文字*/
    private static List<Character> kanaLowerCharacters = Arrays.asList(
        'ｧ', 'ｨ', 'ｩ', 'ｪ', 'ｫ',
        'ｬ', 'ｭ', 'ｮ',
        'ｯ'
    );
    /**半角ｶﾅ文字*/
    private static List<Character> kanaCharacters = new ArrayList<Character>();
    /**半角ｶﾅ文字種*/
    private static List<Character> kanas = new ArrayList<Character>();
    /**ascii文字種*/
    private static List<Character> asciies = Arrays.asList(
        ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        ':', ';', '<', '=', '>', '?', '@',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '[', '\\', ']', '^', '_', '`',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '{', '|', '}', '~'
    );
    
    static {
        kanaCharacters.addAll(kanaUpperCharacters);
        kanaCharacters.addAll(kanaLowerCharacters);
        kanas.addAll(kanaSymbols);
        kanas.addAll(kanaCharacters);
    }
    
    public class 半角ｶﾅ小文字判定 {

        @Test
        public void 半角ｶﾅ小文字はtrue() {
            for (char c : kanaLowerCharacters) {
                assertThat(HalfwidthCharacter.isHalfwidthKanaLowerCharacter(c))
                    .as(c + "")
                    .isTrue();
            }
        }

        @Test
        public void 半角ｶﾅ通常文字はfalse() {
            for (char c : kanaUpperCharacters) {
                assertThat(HalfwidthCharacter.isHalfwidthKanaLowerCharacter(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
    
    public class 半角ｶﾅ文字判定 {

        @Test
        public void 半角ｶﾅ文字はtrue() {
            for (char c : kanaCharacters) {
                assertThat(HalfwidthCharacter.isHalfwidthKanaCharacter(c))
                    .as(c + "")
                    .isTrue();
            }
        }

        @Test
        public void 半角ｶﾅ記号はfalse() {
            for (char c : kanaSymbols) {
                assertThat(HalfwidthCharacter.isHalfwidthKanaCharacter(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
    
    public class 半角ｶﾅ記号判定 {

        @Test
        public void 半角ｶﾅ記号はtrue() {
            for (char c : kanaSymbols) {
                assertThat(HalfwidthCharacter.isHalfwidthKanaSymbol(c))
                    .as(c + "")
                    .isTrue();
            }
        }

        @Test
        public void 半角ｶﾅ文字はfalse() {
            for (char c : kanaCharacters) {
                assertThat(HalfwidthCharacter.isHalfwidthKanaSymbol(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
    
    public class 半角ｶﾅ文字種判定 {

        @Test
        public void 半角ｶﾅ文字種はtrue() {
            for (char c : kanas) {
                assertThat(HalfwidthCharacter.isHalfwidthKana(c))
                    .as(c + "")
                    .isTrue();
            }
        }
        
        @Test
        public void アスキー文字種はfalse() {
            for (char c : asciies) {
                assertThat(HalfwidthCharacter.isHalfwidthKana(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
}
