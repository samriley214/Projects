import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    void allSelfDividing() {
        assertEquals(true,Problem5.allSelfDividing(12));
        assertEquals(true,Problem5.allSelfDividing(15));
        assertEquals(false,Problem5.allSelfDividing(50));
        assertEquals(true,Problem5.allSelfDividing(24));
        assertEquals(false,Problem5.allSelfDividing(374));
    }
}