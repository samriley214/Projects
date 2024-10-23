import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem8Test {

    @Test
    void postfixEvaluator() {

                List<String> list1 = new LinkedList<>(List.of(new String[]{"5", "2", "*", "5", "+", "2", "+"}));
                List<String> list2 = new LinkedList<>(List.of(new String[]{"1", "2", "3", "4", "+", "+", "+"}));
                assertAll(
                        () -> assertEquals(17, Problem8.postfixEvaluator(list1)),
                        () -> assertEquals(10,Problem8.postfixEvaluator(list2))

                );
            }
        }