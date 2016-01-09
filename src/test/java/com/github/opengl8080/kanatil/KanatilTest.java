package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class KanatilTest {

    private static List<Character> kanaSymbols = Arrays.asList('ﾞ', 'ﾟ', '｡', '｢', '｣', '､', '･', 'ｰ');
    private static List<Character> kanaCharacters = Arrays.asList(
        'ｱ', 'ｲ', 'ｳ', 'ｴ', 'ｵ',
        'ｶ', 'ｷ', 'ｸ', 'ｹ', 'ｺ',
        'ｻ', 'ｼ', 'ｽ', 'ｾ', 'ｿ',
        'ﾀ', 'ﾁ', 'ﾂ', 'ﾃ', 'ﾄ',
        'ﾅ', 'ﾆ', 'ﾇ', 'ﾈ', 'ﾉ',
        'ﾊ', 'ﾋ', 'ﾌ', 'ﾍ', 'ﾎ',
        'ﾏ', 'ﾐ', 'ﾑ', 'ﾒ', 'ﾓ',
        'ﾔ', 'ﾕ', 'ﾖ',
        'ﾗ', 'ﾘ', 'ﾙ', 'ﾚ', 'ﾛ',
        'ﾜ', 'ｦ', 'ﾝ',
        'ｧ', 'ｨ', 'ｩ', 'ｪ', 'ｫ',
        'ｬ', 'ｭ', 'ｮ',
        'ｯ'
    );
    private static List<Character> kanas;
    
    @BeforeClass
    public static void setup() {
        kanas = new ArrayList<Character>();
        kanas.addAll(kanaSymbols);
        kanas.addAll(kanaCharacters);
    }

    @Test
    public void 半角ｶﾅ記号以外判定_true() {
        for (char kanaCharacter : kanaCharacters) {
            assertThat(Kanatil.isHalfwidthKanaCharacter(kanaCharacter))
                .as(kanaCharacter + "")
                .isTrue();
        }
    }

    @Test
    public void 半角ｶﾅ記号以外判定_記号はfalse() {
        for (char kanaSymbol : kanaSymbols) {
            assertThat(Kanatil.isHalfwidthKanaCharacter(kanaSymbol))
                .as(kanaSymbol + "")
                .isFalse();
        }
    }

    @Test
    public void 半角ｶﾅ記号判定_true() {
        for (char kanaSymbol : kanaSymbols) {
            assertThat(Kanatil.isHalfwidthKanaSymbol(kanaSymbol))
                .as(kanaSymbol + "")
                .isTrue();
        }
    }

    @Test
    public void 半角ｶﾅ記号判定_記号以外はfalse() {
        for (char kanaCharacter : kanaCharacters) {
            assertThat(Kanatil.isHalfwidthKanaSymbol(kanaCharacter))
                .as(kanaCharacter + "")
                .isFalse();
        }
    }
    
    @Test
    public void 半角ｶﾅ判定_true() {
        for (char kana : kanas) {
            assertThat(Kanatil.isHalfwidthKana(kana))
                .as(kana + "")
                .isTrue();
        }
    }
    
    @Test
    public void 半角ｶﾅ判定_false() {
        char[] asciies = {
            ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            ':', ';', '<', '=', '>', '?', '@',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '[', '\\', ']', '^', '_', '`',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '{', '|', '}', '~'
        };
        
        for (char ascii : asciies) {
            assertThat(Kanatil.isHalfwidthKana(ascii))
                .as(ascii + "")
                .isFalse();
        }
    }
}
