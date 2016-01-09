package com.github.opengl8080.kanatil;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class AsciiCharacterTest {
    
    
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
