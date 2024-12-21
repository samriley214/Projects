import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void isSelfDividing() {
        assertEquals(true,Problem4.isSelfDividing(12));
        assertEquals(true,Problem4.isSelfDividing(10));
        assertEquals(false,Problem4.isSelfDividing(556));
        assertEquals(true,Problem4.isSelfDividing(18));
        assertEquals(false,Problem4.isSelfDividing(374));
    }
}