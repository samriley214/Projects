import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem10Test {

    @Test
    void areParrallelLists() {
        List<Integer> list1 = new LinkedList<>(List.of(new Integer[]{5,10,15,20}));
        List<Integer> list2 = new LinkedList<>(List.of(new Integer[]{20,40,60,80}));
        assertTrue(Problem10.areParrallelLists(list1,list2));
    }
}