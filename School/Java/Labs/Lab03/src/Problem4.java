public class Problem4 {
    /**
     * This method calls a helper method that does tail recursion
     * @param s the string you want to check
     * @return the result of the helper function
     */
    public static String replaceABTR(String s){
        return helper(s,s);
    }

    /**
     * This method does the work of the tail recursion to find all A and replace with B
     * @param s the given string
     * @param acc the accumulator
     * @return the final string with no A
     */
    private static String helper(String s, String acc){
        if(!s.contains("A")){
            return acc;
        }
        else{
            return helper(acc, s.replaceFirst("A","B"));
        }
    }
}
