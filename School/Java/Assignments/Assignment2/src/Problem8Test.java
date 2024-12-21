import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem8Test {

    @Test
    void circleArea() {
        assertAll(
                () -> assertEquals(12.56, Problem8.circleArea(2,0.5),1.5),
                () -> assertEquals(1963, Problem8.circleArea(25,0.01),1.5),
                () -> assertEquals(3.14, Problem8.circleArea(1,0.00001),1.5)
        );
    }
}