import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void replaceABTR() {
        assertAll(
                () -> assertEquals("Bll",Problem4.replaceABTR("All")),
                () -> assertEquals("BBBB",Problem4.replaceABTR("AAAA")),
                () -> assertEquals("all",Problem4.replaceABTR("all"))
        );
    }
}