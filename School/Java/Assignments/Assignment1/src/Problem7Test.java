import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {

    @Test
    void lessThan20() {
        assertAll(
                () -> assertEquals(true,Problem7.lessThan20(19,2,412)),
                () -> assertEquals(false,Problem7.lessThan20(999,888,777)),
                () -> assertEquals(true,Problem7.lessThan20(0,1,2))
        );
    }
}