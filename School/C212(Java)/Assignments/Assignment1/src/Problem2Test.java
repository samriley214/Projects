import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void grocery() {
        assertAll(
                () -> assertEquals(5.66,Problem2.grocery(1,1,1,1,1),0.01),
                () -> assertEquals(5.47, Problem2.grocery(0,1,0,0,2),0.01),
                () -> assertEquals(1.39,Problem2.grocery(0,0,0,1,0),0.01)
        );
    }
}