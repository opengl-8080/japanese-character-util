package com.github.opengl8080.kanatil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Characters {
    public static String toString(List<Character> chars) {
        StringBuffer sb = new StringBuffer(chars.size());
        
        for (char c : chars) {
            sb.append(c);
        }
        
        return sb.toString();
    }
    
    
    /**半角スペース*/
    public static final List<Character> HALF_SPACE = Arrays.asList(' ');
    /**半角数字*/
    public static final List<Character> HALF_NUMBER = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    /**半角記号*/
    public static final List<Character> HALF_SYMBOL = Arrays.asList(
        '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/',
        ':', ';', '<', '=', '>', '?', '@',
        '[', '\\', ']', '^', '_', '`',
        '{', '|', '}', '~'
    );
    /**半角大文字*/
    public static final List<Character> UPPER_ALPHABET = Arrays.asList(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    );
    /**半角小文字*/
    public static final List<Character> LOWER_ALPHABET = Arrays.asList(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    );
    /**半角アルファベット*/
    public static final List<Character> ALPHABET;
    /**アスキー文字*/
    public static final List<Character> ASCII;
    
    static {
        List<Character> list = new ArrayList<Character>();
        list.addAll(HALF_SPACE);
        list.addAll(HALF_NUMBER);
        list.addAll(HALF_SYMBOL);
        list.addAll(UPPER_ALPHABET);
        list.addAll(LOWER_ALPHABET);
        
        ASCII = Collections.unmodifiableList(list);
        
        list = new ArrayList<Character>();
        list.addAll(UPPER_ALPHABET);
        list.addAll(LOWER_ALPHABET);
        
        ALPHABET = Collections.unmodifiableList(list);
    }
    
    /**半角ｶﾅ記号*/
    public static final List<Character> HALFWIDTH_SYMBOL = Arrays.asList('ﾞ', 'ﾟ', '｡', '｢', '｣', '､', '･', 'ｰ');
    /**半角ｶﾅ通常文字*/
    public static final List<Character> HALFWIDTH_UPPER_CHARACTER = Arrays.asList(
        'ｱ', 'ｲ', 'ｳ', 'ｴ', 'ｵ',
        'ﾔ', 'ﾕ', 'ﾖ',
        'ﾂ'
    );
    public static final List<Character> HALFWIDTH_NORMAL_CHARACTER = Arrays.asList(
        'ｶ', 'ｷ', 'ｸ', 'ｹ', 'ｺ',
        'ｻ', 'ｼ', 'ｽ', 'ｾ', 'ｿ',
        'ﾀ', 'ﾁ', 'ﾃ', 'ﾄ',
        'ﾅ', 'ﾆ', 'ﾇ', 'ﾈ', 'ﾉ',
        'ﾊ', 'ﾋ', 'ﾌ', 'ﾍ', 'ﾎ',
        'ﾏ', 'ﾐ', 'ﾑ', 'ﾒ', 'ﾓ',
        'ﾗ', 'ﾘ', 'ﾙ', 'ﾚ', 'ﾛ',
        'ﾜ', 'ｦ', 'ﾝ'
    );
    /**半角ｶﾅ小文字*/
    public static final List<Character> HALFWIDTH_LOWER_CHARACTER = Arrays.asList(
        'ｧ', 'ｨ', 'ｩ', 'ｪ', 'ｫ',
        'ｬ', 'ｭ', 'ｮ',
        'ｯ'
    );
    /**半角ｶﾅ文字*/
    public static final List<Character> HALFWIDTH_CHARACTER;
    /**半角ｶﾅ文字種*/
    public static final List<Character> HALFWIDTH;
    
    static {
        List<Character> list = new ArrayList<Character>();
        list.addAll(HALFWIDTH_UPPER_CHARACTER);
        list.addAll(HALFWIDTH_NORMAL_CHARACTER);
        list.addAll(HALFWIDTH_LOWER_CHARACTER);
        
        HALFWIDTH_CHARACTER = Collections.unmodifiableList(list);

        list = new ArrayList<Character>();
        list.addAll(HALFWIDTH_SYMBOL);
        list.addAll(HALFWIDTH_CHARACTER);
        
        HALFWIDTH = Collections.unmodifiableList(list);
    }
    
    /**通常のひらがな*/
    public static final List<Character> UPPER_HIRAGANA = Arrays.asList(
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
    public static final List<Character> LOWER_HIRAGANA = Arrays.asList(
        'ぁ', 'ぃ', 'ぅ', 'ぇ', 'ぉ',
        'っ',
        'ゃ', 'ゅ', 'ょ',
        'ゎ'
    );
    /**歴史的仮名遣いのひらがな*/
    public static final List<Character> HISTORCAL_HIRAGANA = Arrays.asList(
        'ゐ', 'ゑ'
    );
    /**ひらがな*/
    public static final List<Character> HIRAGANA;
    /**通常のカタナカ*/
    public static final List<Character> UPPER_KATAKANA = Arrays.asList(
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
    public static final List<Character> LOWER_KATAKANA = Arrays.asList(
        'ァ', 'ィ', 'ゥ', 'ェ', 'ォ',
        'ッ',
        'ャ', 'ュ', 'ョ',
        'ヮ'
    );
    /**歴史的仮名遣いのカタナカ*/
    public static final List<Character> HISTORICAL_KATAKANA = Arrays.asList(
        'ヰ', 'ヱ'
    );
    /**カタカナ*/
    public static final List<Character> KATAKANA;
    
    static {
        List<Character> list = new ArrayList<Character>();
        list.addAll(UPPER_HIRAGANA);
        list.addAll(LOWER_HIRAGANA);
        list.addAll(HISTORCAL_HIRAGANA);
        
        HIRAGANA = Collections.unmodifiableList(list);

        list = new ArrayList<Character>();
        list.addAll(UPPER_KATAKANA);
        list.addAll(LOWER_KATAKANA);
        list.addAll(HISTORICAL_KATAKANA);
        
        KATAKANA = Collections.unmodifiableList(list);
    }
}
