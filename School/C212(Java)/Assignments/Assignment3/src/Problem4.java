import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Problem4 {
    /**
     * This method checks an array of mountain heights and finds all the peaks that Joe wants to climb
     * @param H the array of mountain heights
     * @return the peaks that Joe wants to climb
     */
    public static int[] peakFinder(int[] H){
        Set<Integer> peaks = new LinkedHashSet<>();
        if(H.length <= 2){
            return new int[]{};
        }
        for(int i = 1;i < H.length - 1;i++){
            if (H[i] > H[i-1] && H[i] > H[i + 1] ){
                if (!contains(peaks,H[i])){
                    peaks.add(H[i]);
                }
            }
        }
        int[] holder = new int[peaks.size()];
        int temp = 0;
        for(int x : peaks){
            holder[temp] = x;
            temp += 1;
        }
        return holder;
    }

    /**
     * This method checks if a given number is in a set
     * @param set the set you want to check
     * @param x the number you are looking for in the set
     * @return true if it contains the number, false if not
     */
    private static boolean contains(Set<Integer> set, int x){
        for(int t : set){
            if(x == t){
                return true;
            }
        }
        return false;
    }
}
