import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void isLeapYear() {
        assertAll(
                () -> assertEquals(true, Problem4.isLeapYear(2016)),
                () -> assertEquals(false, Problem4.isLeapYear(2005)),
                () -> assertEquals(false, Problem4.isLeapYear(1200))
        );
    }
}