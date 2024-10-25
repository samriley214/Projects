import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void computeGpa() {
        assertAll(
                () -> assertEquals(4, Problem2.computeGpa("A+")),
                () -> assertEquals(3, Problem2.computeGpa("B")),
                () -> assertEquals(2, Problem2.computeGpa("C"))
        );
    }
}