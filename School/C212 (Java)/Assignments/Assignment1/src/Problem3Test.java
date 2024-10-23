import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    void pyramidSurfaceArea() {
        assertAll(
                () -> assertEquals(80.9, Problem3.pyramidSurfaceArea(5,5,5),0.01),
                () -> assertEquals(133.75,Problem3.pyramidSurfaceArea(9,7,2),0.01),
                () -> assertEquals(3.23,Problem3.pyramidSurfaceArea(1,1,1),0.01)
        );
    }
}