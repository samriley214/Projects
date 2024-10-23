import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    void censor() {
        //assertEquals("large",Problem3.censor("large","fart"));
        //assertEquals("****large****",Problem3.censor("fartlargefart","fart"));
        //assertEquals("****head",Problem3.censor("butthead","butt"));
        //assertEquals("large",Problem3.censor("large","lage"));
        //assertEquals("********",Problem3.censor("butthead","butthead"));
        //assertEquals("",Problem3.censor("","yello"));
        //assertEquals("144",Problem3.censor("144",""));
        assertEquals("CanYaobucrCodeFindMultipleCensoredWordsSuchAsYouar****",Problem3.censor("CanYaobucrCodeFindMultipleCensoredWordsSuchAsYouar****",""));
    }
}