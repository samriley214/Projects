import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem12Test {

    @Test
    void stateOfMatter() {
        assertAll(
                () -> assertEquals("solid",Problem12.stateOfMatter(0, 'C')),
                () -> assertEquals("gas",Problem12.stateOfMatter(212,'F')),
                () -> assertEquals("liquid",Problem12.stateOfMatter(53,'F')),
                () -> assertEquals("solid",Problem12.stateOfMatter(0,'F')),
                () -> assertEquals("gas",Problem12.stateOfMatter(399,'C')),
                () -> assertEquals("liquid",Problem12.stateOfMatter(43,'C'))
        );
    }
}