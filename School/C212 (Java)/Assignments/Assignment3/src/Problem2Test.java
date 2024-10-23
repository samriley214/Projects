import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void median() {
        assertEquals(8,Problem2.median(new int[]{1,2,3,6},new int[]{7,8,9,10,11,12}));
        assertEquals(4,Problem2.median(new int[]{1,2},new int[]{4,5,6}));
        assertEquals(8,Problem2.median(new int[]{1,8,9,16},new int[]{1,21,1}));
        assertEquals(56,Problem2.median(new int[]{17,62},new int[]{42,56,1023}));


    }
}