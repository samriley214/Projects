import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void atoi() {
        assertAll(
                () -> assertEquals(4,Problem4.atoi("004BCD")),
                () -> assertEquals(123,Problem4.atoi(" 123ABC")),
                () -> assertEquals(-987,Problem4.atoi("-987+654")),
                () -> assertEquals(-2147483647,Problem4.atoi("-2147483647")),
                () -> assertEquals(-987,Problem4.atoi("-987ABC654"))
                );
    }
}