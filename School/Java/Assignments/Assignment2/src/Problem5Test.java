import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    void compareTo() {
        assertAll(
                () -> assertEquals(1,Problem5.compareTo("yes","no")),
                () -> assertEquals(-1,Problem5.compareTo("a","no")),
                () -> assertEquals(1,Problem5.compareTo("eyebrow","eyeball")),
                () -> assertEquals(-1,Problem5.compareTo("yella","yells")),
                () -> assertEquals(0,Problem5.compareTo("fart","fart"))
                );
    }
}