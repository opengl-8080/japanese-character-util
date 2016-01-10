package com.github.opengl8080.kanatil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public enum AsciiChar {
    /**{@code " "} : スペース*/
    SPACE(' '),
    /**{@code "!"} : 感嘆符*/
    EXCLAMATION('!'),
    /**{@code '"'} : ダブルクォーテーション*/
    DOUBLE_QUOTATION('"'),
    /**{@code "#"} : 番号記号*/
    NUMBER('#'),
    /**{@code "#"} : 番号記号*/
    SHARP('#'),
    /**{@code "$"} : ドル*/
    DOLLAR('$'),
    /**{@code "%"} : パーセント*/
    PERCENT('%'),
    /**{@code "&"} : アンパサンド*/
    AMPERSAND('&'),
    /**{@code "\'"} : アポストロフィ*/
    APOSTROPHE('\''),
    /**{@code "\'"} : アポストロフィ*/
    SINGLE_QUOTATION('\''),
    /**{@code "("} : 左丸括弧*/
    LEFT_PARENTHESIS('('),
    /**{@code ")"} : 右丸括弧*/
    LEFRIGHT_PARENTHESIS(')'),
    /**{@code "*"} : アスタリスク*/
    ASTERISK('*'),
    /**{@code "+"} : プラス*/
    PLUS('+'),
    /**{@code ","} : カンマ*/
    COMMA(','),
    /**{@code "-"} : ハイフン*/
    HYPHEN('-'),
    /**{@code "-"} : ハイフン*/
    MINUS('-'),
    /**{@code "."} : ピリオド*/
    PERIOD('.'),
    /**{@code "."} : ピリオド*/
    DOT('.'),
    /**{@code "/"} : スラッシュ*/
    SLASH('/'),
    /**{@code "0"} : 0*/
    ZERO('0'),
    /**{@code "1"} : 1*/
    ONE('1'),
    /**{@code "2"} : 2*/
    TWO('2'),
    /**{@code "3"} : 3*/
    THREE('3'),
    /**{@code "4"} : 4*/
    FOUR('4'),
    /**{@code "5"} : 5*/
    FIVE('5'),
    /**{@code "6"} : 6*/
    SIX('6'),
    /**{@code "7"} : 7*/
    SEVEN('7'),
    /**{@code "8"} : 8*/
    EIGHT('8'),
    /**{@code "9"} : 9*/
    NINE('9'),
    /**{@code ":"} : コロン*/
    COLON(':'),
    /**{@code ";"} : セミコロン*/
    SEMICOLON(';'),
    /**{@code "<"} : 小なり*/
    LESS_THAN('<'),
    /**{@code "="} : 等号*/
    EQUAL('='),
    /**{@code ">"} : 大なり*/
    GREATER_THAN('>'),
    /**{@code "?"} : 疑問符*/
    QUESTION('?'),
    /**{@code "@"} : 単価記号*/
    AT('@'),
    /**{@code "A"} : A*/
    A('A'),
    /**{@code "B"} : B*/
    B('B'),
    /**{@code "C"} : C*/
    C('C'),
    /**{@code "D"} : D*/
    D('D'),
    /**{@code "E"} : E*/
    E('E'),
    /**{@code "F"} : F*/
    F('F'),
    /**{@code "G"} : G*/
    G('G'),
    /**{@code "H"} : H*/
    H('H'),
    /**{@code "I"} : I*/
    I('I'),
    /**{@code "J"} : J*/
    J('J'),
    /**{@code "K"} : K*/
    K('K'),
    /**{@code "L"} : L*/
    L('L'),
    /**{@code "M"} : M*/
    M('M'),
    /**{@code "N"} : N*/
    N('N'),
    /**{@code "O"} : O*/
    O('O'),
    /**{@code "P"} : P*/
    P('P'),
    /**{@code "Q"} : Q*/
    Q('Q'),
    /**{@code "R"} : R*/
    R('R'),
    /**{@code "S"} : S*/
    S('S'),
    /**{@code "T"} : T*/
    T('T'),
    /**{@code "U"} : U*/
    U('U'),
    /**{@code "V"} : V*/
    V('V'),
    /**{@code "W"} : W*/
    W('W'),
    /**{@code "X"} : X*/
    X('X'),
    /**{@code "Y"} : Y*/
    Y('Y'),
    /**{@code "Z"} : Z*/
    Z('Z'),
    /**{@code "["} : 左角括弧*/
    LEFT_SQUARE_BRACKET('['),
    /**{@code "\\"} : バックスラッシュ*/
    BACK_SLASH('\\'),
    /**{@code "\\"} : バックスラッシュ*/
    YEN('\\'),
    /**{@code "]"} : 右角括弧*/
    RIGHT_SQUARE_BRACKET(']'),
    /**{@code "^"} : サーカムフレックス*/
    CIRCUMFLEX('^'),
    /**{@code "^"} : サーカムフレックス*/
    HAT('^'),
    /**{@code "_"} : アンダースコア*/
    UNDERSCORE('_'),
    /**{@code "_"} : アンダースコア*/
    UNDERBAR('_'),
    /**{@code "_"} : アンダースコア*/
    UNDERLINE('_'),
    /**{@code "`"} : グレイヴ・アクセント*/
    GRAVE_ACCENT('`'),
    /**{@code "`"} : グレイヴ・アクセント*/
    BACK_QUOTATION('`'),
    /**{@code "a"} : a*/
    a('a'),
    /**{@code "b"} : b*/
    b('b'),
    /**{@code "c"} : c*/
    c('c'),
    /**{@code "d"} : d*/
    d('d'),
    /**{@code "e"} : e*/
    e('e'),
    /**{@code "f"} : f*/
    f('f'),
    /**{@code "g"} : g*/
    g('g'),
    /**{@code "h"} : h*/
    h('h'),
    /**{@code "i"} : i*/
    i('i'),
    /**{@code "j"} : j*/
    j('j'),
    /**{@code "k"} : k*/
    k('k'),
    /**{@code "l"} : l*/
    l('l'),
    /**{@code "m"} : m*/
    m('m'),
    /**{@code "n"} : n*/
    n('n'),
    /**{@code "o"} : o*/
    o('o'),
    /**{@code "p"} : p*/
    p('p'),
    /**{@code "q"} : q*/
    q('q'),
    /**{@code "r"} : r*/
    r('r'),
    /**{@code "s"} : s*/
    s('s'),
    /**{@code "t"} : t*/
    t('t'),
    /**{@code "u"} : u*/
    u('u'),
    /**{@code "v"} : v*/
    v('v'),
    /**{@code "w"} : w*/
    w('w'),
    /**{@code "x"} : x*/
    x('x'),
    /**{@code "y"} : y*/
    y('y'),
    /**{@code "z"} : z*/
    z('z'),
    /**{@code "{"} : 左波括弧*/
    LEFT_CURLY_BRACKET('{'),
    /**{@code "|"} : バーティカルバー*/
    VERTICAL_BAR('|'),
    /**{@code "}"} : 右波括弧*/
    RIGHT_CURLY_BRACKET('}'),
    /**{@code "~"} : チルダ*/
    TILDE('~'),
    ;
    
    private final char _c;

    private AsciiChar(char c) {
        this._c = c;
    }

    public char getChar() {
        return this._c;
    }

    public static char[] toCharArray(AsciiChar[] asciies) {
        if (Utils.isEmpty(asciies)) return new char[0];
        
        char[] chars = new char[asciies.length];
        
        for (int i=0; i<asciies.length; i++) {
            chars[i] = asciies[i].getChar();
        }
        
        return chars;
    }

    public static char[] toCharArray(Collection<AsciiChar> asciies) {
        if (Utils.isEmpty(asciies)) return new char[0];
        
        char[] chars = new char[asciies.size()];
        
        int i = 0;
        
        for (AsciiChar ascii : asciies) {
            chars[i] = ascii.getChar();
            i++;
        }
        
        return chars;
    }

    public static char[] toCharArray(Iterable<AsciiChar> asciies) {
        if (Utils.isEmpty(asciies)) return new char[0];
        
        if (asciies instanceof Collection) {
            return toCharArray((Collection<AsciiChar>)asciies);
        }
        
        List<AsciiChar> chars = new ArrayList<AsciiChar>();
        
        for (Iterator<AsciiChar> ite = asciies.iterator(); ite.hasNext();) {
            chars.add(ite.next());
        }
        
        return toCharArray(chars);
    }
}
