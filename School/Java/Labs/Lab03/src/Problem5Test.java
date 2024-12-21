import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    void hyperfactorial() {
        assertAll(
                () -> assertEquals(1,Problem5.hyperfactorial(0)),
                () -> assertEquals(1,Problem5.hyperfactorial(1)),
                () -> assertEquals(4,Problem5.hyperfactorial(2))
        );
    }

    @Test
    void hyperfactorialTR() {
        assertAll(
                () -> assertEquals(1,Problem5.hyperfactorialTR(0)),
                () -> assertEquals(1,Problem5.hyperfactorialTR(1)),
                () -> assertEquals(4,Problem5.hyperfactorialTR(2))
        );
    }
}