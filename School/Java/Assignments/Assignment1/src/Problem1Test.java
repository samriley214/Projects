import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @org.junit.jupiter.api.Test
    void gigameterToLightsecond() {
        assertAll(
                () -> assertEquals(333.56,Problem1.gigameterToLightsecond(100),0.01),
                () -> assertEquals(166.78, Problem1.gigameterToLightsecond(50),0.01),
                () -> assertEquals(33356.41,Problem1.gigameterToLightsecond(10000),0.01)
        );
    }
}