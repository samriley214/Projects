import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void containsMiddleABC() {
        assertAll(
                () -> assertTrue(Problem2.containsMiddleABC("helloABChiya!")),
                () -> assertTrue(Problem2.containsMiddleABC("ABC")),
                () -> assertTrue(Problem2.containsMiddleABC("aABCc!")),
                () -> assertFalse(Problem2.containsMiddleABC("notInTheMiddleABCmid!"))
        );
    }
}