import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    @Test
    void computeRoundSum() {
        assertAll(
                () -> assertEquals(110,Problem6.computeRoundSum(11,26,70)),
                () -> assertEquals(20,Problem6.computeRoundSum(-99,0,117)),
                () -> assertEquals(0,Problem6.computeRoundSum(102,74,-170))
        );
    }
}