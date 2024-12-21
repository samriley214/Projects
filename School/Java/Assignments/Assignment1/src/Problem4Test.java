import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void flStrip() {
        assertAll(
                () -> assertEquals("ortnit",Problem4.flStrip("fortnite")),
                () -> assertEquals("ello",Problem4.flStrip("yellow")),
                () -> assertEquals("",Problem4.flStrip("hi"))
                );
    }
}