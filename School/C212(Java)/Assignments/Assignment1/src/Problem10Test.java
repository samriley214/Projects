import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem10Test {

    @Test
    void fitCandy() {
        assertAll(
                () -> assertEquals(4,Problem10.fitCandy(4,1,9)),
                () -> assertEquals(4,Problem10.fitCandy(4,1,4)),
                () -> assertEquals(1,Problem10.fitCandy(1,2,6)),
                () -> assertEquals(-1,Problem10.fitCandy(6,1,13)),
                () -> assertEquals(50,Problem10.fitCandy(60,100,550)),
                () -> assertEquals(7,Problem10.fitCandy(7,1,12)),
                () -> assertEquals(-1,Problem10.fitCandy(7,1,13))
        );
    }
}