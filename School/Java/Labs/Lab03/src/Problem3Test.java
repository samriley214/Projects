import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    void replaceAB() {
        assertAll(
                () -> assertEquals("Bll",Problem3.replaceAB("All")),
                () -> assertEquals("BBBB",Problem3.replaceAB("AAAA")),
                () -> assertEquals("all",Problem3.replaceAB("all"))
        );
    }
}