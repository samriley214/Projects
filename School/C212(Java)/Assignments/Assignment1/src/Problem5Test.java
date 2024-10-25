import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    void cutUsername() {
        assertAll(
                () -> assertEquals("samrile",Problem5.cutUsername("samrile@iu.edu")),
                () -> assertEquals("google",Problem5.cutUsername("google@aol.com")),
                () -> assertEquals("catlover64",Problem5.cutUsername("catlover64@gmail.com"))
        );
    }
}