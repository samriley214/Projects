import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem8Test {

    @Test
    void cond() {
        assertAll(
                () -> assertEquals(true,Problem8.cond(true,true)),
                () -> assertEquals(false,Problem8.cond(true,false)),
                () -> assertEquals(true,Problem8.cond(false,true)),
                () -> assertEquals(true,Problem8.cond(false,false))
        );
    }

    @Test
    void bicond() {
        assertAll(
                () -> assertEquals(true,Problem8.bicond(true,true)),
                () -> assertEquals(false,Problem8.bicond(false,true)),
                () -> assertEquals(false,Problem8.bicond(true,false)),
                () -> assertEquals(true, Problem8.bicond(false,false))
        );
    }

    @Test
    void and() {
        assertAll(
                () -> assertEquals(true,Problem8.and(true,true)),
                () -> assertEquals(false,Problem8.and(false,true)),
                () -> assertEquals(false,Problem8.and(true,false)),
                () -> assertEquals(false, Problem8.and(false,false))
        );
    }

    @Test
    void or() {
        assertAll(
                () -> assertEquals(true,Problem8.or(true,true)),
                () -> assertEquals(true,Problem8.or(false,true)),
                () -> assertEquals(true,Problem8.or(true,false)),
                () -> assertEquals(false,Problem8.or(false,false))
        );
    }

    @Test
    void not() {
        assertAll(
                () -> assertEquals(true, Problem8.not(false)),
                () -> assertEquals(false, Problem8.not(true))
        );
    }
}