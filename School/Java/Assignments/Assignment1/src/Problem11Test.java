import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem11Test {

    @Test
    void isValidIpv4() {
        assertAll(
                () -> assertEquals(true,Problem11.isValidIpv4("192.168.1.244")),
                () -> assertEquals(true,Problem11.isValidIpv4("192.168.192.52")),
                () -> assertEquals(false,Problem11.isValidIpv4("192.168.1.256")),
                () -> assertEquals(false,Problem11.isValidIpv4("192.168.1201.23")),
                () -> assertEquals(false,Problem11.isValidIpv4("192.168.1201.ABC")),
                () -> assertEquals(false,Problem11.isValidIpv4("ABC.DEF.GHI")),
                () -> assertEquals(false,Problem11.isValidIpv4("192.168.1A6.201"))
        );
    }
}