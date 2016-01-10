package com.github.opengl8080.kanatil;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class AsciiCharTest {

    public class char配列への変換 {
        
        @Test
        public void 配列からの変換() throws Exception {
            // exercise
            char[] actual = AsciiChar.toCharArray(new AsciiChar[] {AsciiChar.A, AsciiChar.B, AsciiChar.C});
            
            // verify
            assertThat(toCharacterArray(actual), is(arrayContaining('A', 'B', 'C')));
        }
        
        @Test
        public void 配列からの変換_nullを渡すと空のchar配列を返す() throws Exception {
            // exercise
            char[] actual = AsciiChar.toCharArray((AsciiChar[])null);
            
            // verify
            assertThat(toCharacterArray(actual), is(emptyArray()));
        }
        
        @Test
        public void Collectionからの変換() throws Exception {
            // exercise
            char[] actual = AsciiChar.toCharArray(Arrays.asList(AsciiChar.A, AsciiChar.B, AsciiChar.C));
            
            // verify
            assertThat(toCharacterArray(actual), is(arrayContaining('A', 'B', 'C')));
        }
        
        @Test
        public void Collectionからの変換_nullを渡すと空のchar配列を返す() throws Exception {
            // exercise
            char[] actual = AsciiChar.toCharArray((List<AsciiChar>)null);
            
            // verify
            assertThat(toCharacterArray(actual), is(emptyArray()));
        }
    }
    
    private static Character[] toCharacterArray(char[] charArray) {
        Character[] to = new Character[charArray.length];
        
        for (int i=0; i<charArray.length; i++) {
            to[i] = charArray[i];
        }
        
        return to;
    }

}
