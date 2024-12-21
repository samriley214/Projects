import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void fizzBuzz() {
        assertArrayEquals(new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz"},Problem1.fizzBuzz(1,12));
        assertArrayEquals(new String[]{"FizzBuzz", "16", "17", "Fizz"},Problem1.fizzBuzz(15,18));
    }
}