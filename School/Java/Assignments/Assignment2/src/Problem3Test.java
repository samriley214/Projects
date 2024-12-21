import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    void collatz() {
        assertAll(
                () -> assertEquals(1,Problem3.collatz(1)),
                () -> assertEquals(1,Problem3.collatz(27)),
                () -> assertEquals(1,Problem3.collatz(33)),
                () -> assertEquals(1,Problem3.collatz(42)),
                () -> assertEquals(1,Problem3.collatz(51))
                );
    }

    @Test
    void collatzTR() {
        assertAll(
                () -> assertEquals(1,Problem3.collatzTR(1)),
                () -> assertEquals(1,Problem3.collatzTR(27)),
                () -> assertEquals(1,Problem3.collatzTR(33)),
                () -> assertEquals(1,Problem3.collatzTR(42)),
                () -> assertEquals(1,Problem3.collatzTR(51))
        );
    }

    @Test
    void collatzLoop() {
        assertAll(
                () -> assertEquals(1,Problem3.collatzLoop(1)),
                () -> assertEquals(1,Problem3.collatzLoop(27)),
                () -> assertEquals(1,Problem3.collatzLoop(33)),
                () -> assertEquals(1,Problem3.collatzLoop(42)),
                () -> assertEquals(1,Problem3.collatzLoop(51))
                );
    }
}