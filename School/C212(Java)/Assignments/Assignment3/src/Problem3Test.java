import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {
Set<List<Integer>> A1= new HashSet<>();
List<Integer> T11= new ArrayList<>();


    @Test
    void twoSum() {
        assertEquals(new HashSet<>(Arrays.asList(new int[]{2,2},new int[]{6,-2})),Problem3.twoSum(new int[]{2,2,4,10,6,-2},4));
        assertEquals(new HashSet<>(Arrays.asList(new int[]{7,2})),Problem3.twoSum(new int[]{7,2,43,0,6,-2},9));
        assertEquals(new HashSet<>(Arrays.asList(new int[]{2,2},new int[]{6,-2})),Problem3.twoSum(new int[]{2,2,4,10,6,-2},4));
        assertEquals(new HashSet<>(Arrays.asList(new int[]{2,2},new int[]{6,-2})),Problem3.twoSum(new int[]{2,2,4,10,6,-2},4));

    }
}