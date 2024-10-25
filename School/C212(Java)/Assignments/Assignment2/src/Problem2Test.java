import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void subfactorial() {
        assertAll(
                () -> assertEquals(2,Problem2.subfactorial(3)),
                () -> assertEquals(44,Problem2.subfactorial(5)),
                () -> assertEquals(9,Problem2.subfactorial(4))
        );
    }

    @Test
    void subfactorialTR() {
        assertAll(
                () -> assertEquals(2,Problem2.subfactorialTR(3)),
                () -> assertEquals(44,Problem2.subfactorialTR(5)),
                () -> assertEquals(9,Problem2.subfactorialTR(4))
        );
    }

    @Test
    void subfactorialLoop() {
        assertAll(
                () -> assertEquals(2,Problem2.subfactorialLoop(3)),
                () -> assertEquals(44,Problem2.subfactorialLoop(5)),
                () -> assertEquals(9,Problem2.subfactorialLoop(4))
        );
    }
}