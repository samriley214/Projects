import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void countStrTR() {
        assertAll(
                () -> assertEquals(0,Problem2.countStrTR("hello")),
                () -> assertEquals(4,Problem2.countStrTR("strastrastrstr")),
                () -> assertEquals(2,Problem2.countStrTR("string star of strings"))
        );
    }
}