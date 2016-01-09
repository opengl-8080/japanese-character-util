package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class FullwidthCharacterTest {
    /**通常のひらがな*/
    private static List<Character> upperHiraganas = Arrays.asList(
        'あ', 'い', 'う', 'え', 'お',
        'か', 'き', 'く', 'け', 'こ',
        'さ', 'し', 'す', 'せ', 'そ',
        'た', 'ち', 'つ', 'て', 'と',
        'な', 'に', 'ぬ', 'ね', 'の',
        'は', 'ひ', 'ふ', 'へ', 'ほ',
        'ま', 'み', 'む', 'め', 'も',
        'や', 'ゆ', 'よ',
        'ら', 'り', 'る', 'れ', 'ろ',
        'わ', 'を', 'ん',
        'が', 'ぎ', 'ぐ', 'げ', 'げ',
        'ざ', 'じ', 'ず', 'ぜ', 'ぞ',
        'だ', 'ぢ', 'づ', 'で', 'ど',
        'ば', 'び', 'ぶ', 'べ', 'ぼ',
        'ぱ', 'ぴ', 'ぷ', 'ぺ', 'ぽ'
    );
    /**小文字のひらがな*/
    private static List<Character> lowerHiraganas = Arrays.asList(
        'ぁ', 'ぃ', 'ぅ', 'ぇ', 'ぉ',
        'っ',
        'ゃ', 'ゅ', 'ょ',
        'ゎ'
    );
    /**歴史的仮名遣いのひらがな*/
    private static List<Character> historicalHiraganas = Arrays.asList(
        'ゐ', 'ゑ'
    );
    /**ひらがな*/
    private static List<Character> hiraganas = new ArrayList<Character>();
    /**通常のカタナカ*/
    private static List<Character> upperKatanakas = Arrays.asList(
        'ア', 'イ', 'ウ', 'エ', 'オ',
        'カ', 'キ', 'ク', 'ケ', 'コ',
        'サ', 'シ', 'ス', 'セ', 'ソ',
        'タ', 'チ', 'ツ', 'テ', 'ト',
        'ナ', 'ニ', 'ヌ', 'ネ', 'ノ',
        'ハ', 'ヒ', 'フ', 'ヘ', 'ホ',
        'マ', 'ミ', 'ム', 'メ', 'モ',
        'ヤ', 'ユ', 'ヨ',
        'ラ', 'リ', 'ル', 'レ', 'ロ',
        'ワ', 'ヲ', 'ン',
        'ガ', 'ギ', 'グ', 'ゲ', 'ゴ',
        'ザ', 'ジ', 'ズ', 'ゼ', 'ゾ',
        'ダ', 'ヂ', 'ヅ', 'デ', 'ド',
        'バ', 'ビ', 'ブ', 'ベ', 'ボ',
        'パ', 'ピ', 'プ', 'ペ', 'ポ',
        'ヴ'
    );
    /**小文字のカタカナ*/
    private static List<Character> lowerKatakanas = Arrays.asList(
        'ァ', 'ィ', 'ゥ', 'ェ', 'ォ',
        'ッ',
        'ャ', 'ュ', 'ョ',
        'ヮ'
    );
    /**歴史的仮名遣いのカタナカ*/
    private static List<Character> historicalKatanakas = Arrays.asList(
        'ヰ', 'ヱ'
    );
    /**カタカナ*/
    private static List<Character> katakanas = new ArrayList<Character>();
    
    static {
        hiraganas.addAll(upperHiraganas);
        hiraganas.addAll(lowerHiraganas);
        hiraganas.addAll(historicalHiraganas);

        katakanas.addAll(upperKatanakas);
        katakanas.addAll(lowerKatakanas);
        katakanas.addAll(historicalKatanakas);
    }

    public class ひらがな判定 {
        
        @Test
        public void ひらがなの場合はtrue() throws Exception {
            for (char c : hiraganas) {
                assertThat(FullwidthCharacter.isHiragana(c))
                    .as(c + "")
                    .isTrue();
            }
        }
        @Test
        public void カタカナの場合はfalse() throws Exception {
            for (char c : katakanas) {
                assertThat(FullwidthCharacter.isHiragana(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }

    public class カタカナ判定 {

        @Test
        public void カタカナの場合はtrue() throws Exception {
            for (char c : katakanas) {
                assertThat(FullwidthCharacter.isKatakana(c))
                    .as(c + "")
                    .isTrue();
            }
        }
        @Test
        public void ひらがなの場合はfalse() throws Exception {
            for (char c : hiraganas) {
                assertThat(FullwidthCharacter.isKatakana(c))
                    .as(c + "")
                    .isFalse();
            }
        }
    }
    
}
