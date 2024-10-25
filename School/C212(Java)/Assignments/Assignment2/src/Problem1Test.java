import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @org.junit.jupiter.api.Test
    void gcdTR() {
        assertAll(
                () -> assertEquals(4, Problem1.gcdTR(2260,816)),
                () -> assertEquals(1, Problem1.gcdTR(7,13)),
                () -> assertEquals(10, Problem1.gcdTR(100,10))
                );
    }

    @Test
    void gcdLoop() {
        assertAll(
                () -> assertEquals(6, Problem1.gcdLoop(78,66)),
                () -> assertEquals(1, Problem1.gcdLoop(7,13)),
                () -> assertEquals(10, Problem1.gcdLoop(100,10))
        );
    }
}