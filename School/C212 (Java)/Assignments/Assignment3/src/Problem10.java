import java.util.List;

public class Problem10 {
    /**
     * This method checks if the two Lists are parallel
     * @param t the first list
     * @param u the second list
     * @return true if parallel, false if not
     * @param <T> generic object
     */
    public static <T extends List<Integer>> boolean areParrallelLists(T t, T u) {
        float factor = (float) t.getFirst() /u.getFirst();
        for(int i = 0; i < t.size();i++){
            if(u.get(i) * factor != t.get(i)){
                return false;
            }
        }
        return true;
    }
    }

