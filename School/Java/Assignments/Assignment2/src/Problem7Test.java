import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {

    @Test
    void countPairs() {
        assertAll(
                () -> assertEquals(1,Problem7.countPairs(2)),
                () -> assertEquals(3,Problem7.countPairs(10)),
                () -> assertEquals(4,Problem7.countPairs(20)),
                () -> assertEquals(6,Problem7.countPairs(100))
        );
    }
}