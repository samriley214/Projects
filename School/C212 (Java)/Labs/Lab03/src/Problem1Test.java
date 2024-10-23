import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @org.junit.jupiter.api.Test
    void countStr() {
        assertAll(
                () -> assertEquals(0,Problem1.countStr("hello")),
                () -> assertEquals(4,Problem1.countStr("strastrastrstr")),
                () -> assertEquals(2,Problem1.countStr("string star of strings"))
        );
    }
}