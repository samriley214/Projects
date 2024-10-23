import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void peakFinder() {
        assertArrayEquals(new int[]{13}, Problem4.peakFinder(new int[]{9,13,7,2,8}));
        assertArrayEquals(new int[]{8}, Problem4.peakFinder(new int[]{8,7,8,7,8,7,8,7}));
        assertArrayEquals(new int[]{84,9}, Problem4.peakFinder(new int[]{111,27,84,31,5,9,4,3,2,1,64}));
        assertArrayEquals(new int[]{}, Problem4.peakFinder(new int[]{}));
        assertArrayEquals(new int[]{}, Problem4.peakFinder(new int[]{1}));
        assertArrayEquals(new int[]{}, Problem4.peakFinder(new int[]{1,2}));
        assertArrayEquals(new int[]{2}, Problem4.peakFinder(new int[]{1,2,1}));
        assertArrayEquals(new int[]{3}, Problem4.peakFinder(new int[]{1,2,3,2,1}));

    }
}