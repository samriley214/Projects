import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem9Test {

    @Test
    void stringifyList() {
        List<Integer> list1 = new LinkedList<>(List.of(new Integer[]{1,2,3,4,5}));
        List<Boolean> list2 = new LinkedList<>(List.of(new Boolean[]{true,false,false,true,false}));
        assertEquals("1,2,3,4,5",Problem9.stringifyList(list1));
        assertEquals("true,false,false,true,false",Problem9.stringifyList(list2));
    }
}