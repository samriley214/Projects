import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    @Test
    void wordCount() {
        assertEquals(new HashMap<String, Integer>(), Problem6.wordCount("Hello world, the world is healthy, is it not? I certainly agree that the world is #1 and healthy."));
    }
}