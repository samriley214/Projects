import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3 {
    /**
     * This method finds all the combinations that in an array that add up to an integer
     * @param A the array you want to check
     * @param t the integer you want to add to
     * @return the set of combinations
     */
    public static Set<List<Integer>> twoSum(int[] A, int t){
        Set<List<Integer>> L= new HashSet<>();
        ArrayList<Integer> S= new ArrayList<>();
        S.add(A[0]);
        for (int j : A) {
            if (contains(S, t - j)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(t - j);
                temp.add(j);
                L.add(temp);
            } else {
                S.add(j);
            }
        }
        return L;
    }

    /**
     * This method check if an integer is in a given array
     * @param S the array you want to check
     * @param t the number you are looking for
     * @return true if the number is in the array false if not
     */
    private static boolean contains(ArrayList<Integer> S, int t){
        for(int x : S){
            if(x == t){
                return true;
            }
        }
        return false;
    }
}
