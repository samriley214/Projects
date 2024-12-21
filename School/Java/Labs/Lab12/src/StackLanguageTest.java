import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.AbstractMasterDetailListProcessor;

import static org.junit.jupiter.api.Assertions.*;

public class StackLanguageTest {
    @org.junit.jupiter.api.Test
    void testStack01(){
        StackLanguage sl1 = new StackLanguage();
        sl1.readFile("input01.sl");
        assertEquals(42.0,sl1.interpret(),0.01, "Test 1 failed");
        assertDoesNotThrow(() -> sl1.interpret());

        StackLanguage sl2 = new StackLanguage();
        sl2.readFile("input02.sl");
        assertEquals(100.0,sl2.interpret(),0.01,"Test 2 failed");
        assertDoesNotThrow(() -> sl2.interpret());

        StackLanguage sl3 = new StackLanguage();
        sl3.readFile("input03.sl");
        assertEquals(42,sl3.interpret(),0.01,"Test 3 failed");
        assertDoesNotThrow(() -> sl3.interpret());

        StackLanguage sl4 = new StackLanguage();
        sl4.readFile("input04.sl");
        assertEquals(42,sl4.interpret(),0.01,"Test 4 failed");
        assertDoesNotThrow(() -> sl4.interpret());
    }

    @Test
    void testStack02(){
        StackLanguage sl1 = new StackLanguage();
        sl1.readFile("input05-badpeek.sl");
        assertThrows(IllegalArgumentException.class, () -> sl1.interpret());

        StackLanguage sl2 = new StackLanguage();
        sl2.readFile("input06-badpop.sl");
        assertThrows(IllegalArgumentException.class, () -> sl2.interpret());

        StackLanguage sl3 = new StackLanguage();
        sl3.readFile("input07-badxchg.sl");
        assertThrows(IllegalArgumentException.class, () -> sl3.interpret());

        StackLanguage sl4 = new StackLanguage();
        sl4.readFile("input08-badcmd.sl");
        assertThrows(IllegalArgumentException.class, () -> sl4.interpret());
    }
}
