package com.github.opengl8080.kanatil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class HalfwidthStringTest {
    
    public class コンストラクタ {
        
        @Rule
        public ExpectedException ex = ExpectedException.none();
        
        @Test
        public void 半角ｶﾅ以外の文字が含まれる場合_例外がスローされる() throws Exception {
            // setup
            String ascii = Characters.toString(Characters.ASCII);
            
            // verify
            ex.expect(IllegalCharacterException.class);
            ex.expectMessage("半角ｶﾅ以外の文字が含まれます : " + ascii);
            
            // exercise
            new HalfwidthString(ascii);
        }
        
        @Test
        public void 半角ｶﾅのみの場合_例外はスローされない() throws Exception {
            // setup
            String ascii = Characters.toString(Characters.HALFWIDTH);
            
            // exercise
            new HalfwidthString(ascii);
        }
        
        @Test
        public void nullの場合_例外はスローされない() throws Exception {
            // exercise
            new HalfwidthString(null);
        }
        
        @Test
        public void 空文字の場合_例外はスローされない() throws Exception {
            // exercise
            new HalfwidthString("");
        }
    }
    
    public class toString {
        @Test
        public void コンストラクタで渡した文字列が返される() throws Exception {
            // setup
            String text = "ｱｲｳｴｵ";
            HalfwidthString string = new HalfwidthString(text);
            
            // exercise
            String actual = string.toString();
            
            // verify
            assertThat(actual, is(text));
        }
        
        @Test
        public void nullをコンストラクタで渡した場合_空文字が返される() throws Exception {
            // setup
            HalfwidthString string = new HalfwidthString(null);
            
            // exercise
            String actual = string.toString();
            
            // verify
            assertThat(actual, is(""));
        }
    }
    
    public class 記号のみであることの判定 {
        
        @Test
        public void 記号のみの場合はtrue() throws Exception {
            assertThatIsSymbol(Characters.toString(Characters.HALFWIDTH_SYMBOL), true);
        }
        
        @Test
        public void 記号以外の文字が含まれる場合はfalse() throws Exception {
            assertThatIsSymbol("ｱ｢", false);
        }
        
        public void assertThatIsSymbol(String text, boolean expected) {
            // setup
            HalfwidthString string = new HalfwidthString(text);
            
            // exercise
            boolean actual = string.isSymbol();
            
            // verify
            assertThat(actual, is(expected));
        }
    }
    
    public class 文字のみであることの判定 {
        
        @Test
        public void 文字のみの場合はtrue() throws Exception {
            assertThatIsCharacter(Characters.toString(Characters.HALFWIDTH_CHARACTER), true);
        }
        
        @Test
        public void 文字以外の記号が含まれる場合はfalse() throws Exception {
            assertThatIsCharacter("ｱ｢", false);
        }
        
        public void assertThatIsCharacter(String text, boolean expected) {
            // setup
            HalfwidthString string = new HalfwidthString(text);
            
            // exercise
            boolean actual = string.isCharacter();
            
            // verify
            assertThat(actual, is(expected));
        }
    }
    
    public class 空文字判定 {
        
        @Test
        public void 空文字の場合はtrue() throws Exception {
            assertThatIsEmpty("", true);
        }
        
        @Test
        public void 空文字でない場合はfalse() throws Exception {
            assertThatIsEmpty("ｱ", false);
        }
        
        public void assertThatIsEmpty(String text, boolean expected) {
            // setup
            HalfwidthString string = new HalfwidthString(text);
            
            // exercise
            boolean actual = string.isEmpty();
            
            // verify
            assertThat(actual, is(expected));
        }
    }
    
    public class 文字の長さ取得 {
        
        @Test
        public void 空文字の場合は0() throws Exception {
            assertThatLength("", 0);
        }
        
        @Test
        public void 文字を持つ場合_その文字数() throws Exception {
            assertThatLength("ｱ", 1);
        }
        
        public void assertThatLength(String text, int length) {
            // setup
            HalfwidthString string = new HalfwidthString(text);
            
            // exercise
            int actual = string.length();
            
            // verify
            assertThat(actual, is(length));
        }
    }
    
    public class 小文字化 {
        
        @Test
        public void 小文字に変換できる() throws Exception {
            assertThatToLowerCase(
                Characters.toString(Characters.HALFWIDTH_UPPER_CHARACTER),
                Characters.toString(Characters.HALFWIDTH_LOWER_CHARACTER)
            );
        }

        @Test
        public void 小文字化できない文字が含まれる場合も_小文字化可能な文字だけが小文字化できる() throws Exception {
            assertThatToLowerCase("ｱｶｧ", "ｧｶｧ");
        }

        @Test
        public void 空文字はそのまま空文字になる() throws Exception {
            assertThatToLowerCase("", "");
        }

        public void assertThatToLowerCase(String org, String expected) throws Exception {
            // setup
            HalfwidthString text = new HalfwidthString(org);
            
            // exercise
            HalfwidthString lower = text.toLowerCase();
            
            // verify
            assertThat(lower.toString(), is(expected));
        }
    }
    
    public class 大文字化 {
        
        @Test
        public void 大文字に変換できる() throws Exception {
            assertThatToUpperCase(
                Characters.toString(Characters.HALFWIDTH_LOWER_CHARACTER),
                Characters.toString(Characters.HALFWIDTH_UPPER_CHARACTER)
            );
        }

        @Test
        public void 大文字化できない文字が含まれる場合も_大文字化可能な文字だけが大文字化できる() throws Exception {
            assertThatToUpperCase("ｱｶｧ", "ｱｶｱ");
        }

        @Test
        public void 空文字はそのまま空文字になる() throws Exception {
            assertThatToUpperCase("", "");
        }

        public void assertThatToUpperCase(String org, String expected) throws Exception {
            // setup
            HalfwidthString text = new HalfwidthString(org);
            
            // exercise
            HalfwidthString upper = text.toUpperCase();
            
            // verify
            assertThat(upper.toString(), is(expected));
        }
    }
    
    public class 同値判定 {
        
        @Test
        public void 同じ文字列を含む場合_同値と判定される() throws Exception {
            assertThatEquals("ｱｲｳｴｵ", "ｱｲｳｴｵ", true);
        }
        
        @Test
        public void 文字列が異なる場合_同値でないと判定される() throws Exception {
            assertThatEquals("ｱｲｳｴｵ", "ｧｲｳｴｵ", false);
        }
        
        @Test
        public void 相手がnullの場合_同値でないと判定される() throws Exception {
            assertThatEquals("ｱｲｳｴｵ", null, false);
        }
        
        @Test
        public void 異なるクラスのインスタンスを渡した場合_同値でないと判定される() throws Exception {
            // setup
            HalfwidthString foo = new HalfwidthString("ｱｲｳｴｵ");
            
            // exercise
            boolean actual = foo.equals(new Object());
            
            // verify
            assertThat(actual, is(false));
        }
        
        public void assertThatEquals(String fooText, String barText, boolean expected) {
            // setup
            HalfwidthString foo = new HalfwidthString(fooText);
            HalfwidthString bar = new HalfwidthString(barText);
            
            // exercise
            boolean actual = foo.equals(bar);
            
            // verify
            assertThat(actual, is(expected));
        }
    }
    
    public class ハッシュ値生成 {

        @Test
        public void 同じ文字列の場合_同じハッシュ値を生成する() throws Exception {
            // setup
            HalfwidthString foo = new HalfwidthString("ｱｲｳｴｵ");
            HalfwidthString bar = new HalfwidthString("ｱｲｳｴｵ");
            
            // verify
            assertThat(foo.hashCode(), is(bar.hashCode()));
        }
        
        @Test
        public void 文字列が異なる場合_異なるハッシュ値を生成する() throws Exception {
            // setup
            HalfwidthString foo = new HalfwidthString("ｱｲｳｴｵ");
            HalfwidthString bar = new HalfwidthString("ｧｲｳｴｵ");
            
            // verify
            assertThat(foo.hashCode(), is(not(bar.hashCode())));
        }
    }
    
    public class 半角ｶﾅ小文字判定 {

        @Test
        public void 半角ｶﾅ小文字はtrue() {
            for (Character c : Characters.HALFWIDTH_LOWER_CHARACTER) {
                assertThatLowerCharacter(c, true);
            }
        }

        @Test
        public void 半角ｶﾅ通常文字はfalse() {
            for (Character c : Characters.HALFWIDTH_UPPER_CHARACTER) {
                assertThatLowerCharacter(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatLowerCharacter(null, false);
        }
        
        private void assertThatLowerCharacter(Character c, boolean expected) {
            assertThat(c + "", HalfwidthString.isHalfwidthLowerCharacter(c), is(expected));
        }
    }
    
    public class 半角ｶﾅ文字_文字列判定 {

        @Test
        public void 半角ｶﾅ文字はtrue() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_CHARACTER, true);
        }

        @Test
        public void 半角ｶﾅ記号はfalse() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_SYMBOL, false);
        }
        
        private void assertThatHalfwidthCharacter(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(str, HalfwidthString.isHalfwidthCharacter(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(HalfwidthString.isHalfwidthCharacter(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(HalfwidthString.isHalfwidthCharacter((String)null), is(false));
        }
    }
    
    public class 半角ｶﾅ文字判定 {

        @Test
        public void 半角ｶﾅ文字はtrue() {
            for (Character c : Characters.HALFWIDTH_CHARACTER) {
                assertThatCharacter(c, true);
            }
        }

        @Test
        public void 半角ｶﾅ記号はfalse() {
            for (Character c : Characters.HALFWIDTH_SYMBOL) {
                assertThatCharacter(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatCharacter(null, false);
        }
        
        private void assertThatCharacter(Character c, boolean expected) {
            assertThat(c + "", HalfwidthString.isHalfwidthCharacter(c), is(expected));
        }
    }
    
    public class 半角ｶﾅ記号_文字列判定 {

        @Test
        public void 半角ｶﾅ記号はtrue() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_SYMBOL, true);
        }

        @Test
        public void 半角ｶﾅ文字はfalse() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH_CHARACTER, false);
        }
        
        private void assertThatHalfwidthCharacter(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(str, HalfwidthString.isHalfwidthSymbol(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(str, HalfwidthString.isHalfwidthSymbol(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(HalfwidthString.isHalfwidthSymbol((String)null), is(false));
        }
    }
    
    public class 半角ｶﾅ記号判定 {

        @Test
        public void 半角ｶﾅ記号はtrue() {
            for (Character c : Characters.HALFWIDTH_SYMBOL) {
                assertThatSymbol(c, true);
            }
        }

        @Test
        public void 半角ｶﾅ文字はfalse() {
            for (Character c : Characters.HALFWIDTH_CHARACTER) {
                assertThatSymbol(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatSymbol(null, false);
        }
        
        private void assertThatSymbol(Character c, boolean expected) {
            assertThat(c + "", HalfwidthString.isHalfwidthSymbol(c), is(expected));
        }
    }
    
    public class 半角ｶﾅ文字種_文字列判定 {

        @Test
        public void 半角ｶﾅ文字種はtrue() {
            assertThatHalfwidthCharacter(Characters.HALFWIDTH, true);
        }

        @Test
        public void アスキー文字種はfalse() {
            assertThatHalfwidthCharacter(Characters.ASCII, false);
        }
        
        private void assertThatHalfwidthCharacter(List<Character> chars, boolean expected) {
            String str = Characters.toString(chars);
            assertThat(str, HalfwidthString.isHalfwidth(str), is(expected));
        }

        @Test
        public void サロゲートペア文字が含まれる場合はfalse() {
            String str = "abc\uD867\uDE3Ddef";
            assertThat(str, HalfwidthString.isHalfwidth(str), is(false));
        }

        @Test
        public void nullを渡した場合はfalseを返す() {
            assertThat(HalfwidthString.isHalfwidth((String)null), is(false));
        }
    }
    
    public class 半角ｶﾅ文字種判定 {

        @Test
        public void 半角ｶﾅ文字種はtrue() {
            for (Character c : Characters.HALFWIDTH_CHARACTER) {
                assertThatHalfwidth(c, true);
            }
        }
        
        @Test
        public void アスキー文字種はfalse() {
            for (Character c : Characters.ASCII) {
                assertThatHalfwidth(c, false);
            }
        }

        @Test
        public void nullはfalse() {
            assertThatHalfwidth(null, false);
        }
        
        private void assertThatHalfwidth(Character c, boolean expected) {
            assertThat(c + "", HalfwidthString.isHalfwidth(c), is(expected));
        }
    }
}
