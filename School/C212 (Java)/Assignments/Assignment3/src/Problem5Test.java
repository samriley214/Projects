import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    void tokenize() {
        assertEquals(new ArrayList<String>(), Problem5.tokenize("bob the builder", 'b'));
    }
}