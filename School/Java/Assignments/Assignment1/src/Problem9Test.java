import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem9Test {

    @Test
    void isInsideCircle() {
        assertAll(
                () -> assertEquals(true,Problem9.isInsideCircle(1,1,1,1,1)),
                () -> assertEquals(false, Problem9.isInsideCircle(5,5,5,17,2)),
                () -> assertEquals(false,Problem9.isInsideCircle(0,0,1,2,2))
        );
    }
}