import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    void sortThreeStrings() {
        assertAll(
                () -> assertEquals("Able,Baker,Charlie", Problem3.sortThreeStrings("Charlie","Able","Baker"))
        );
    }
}