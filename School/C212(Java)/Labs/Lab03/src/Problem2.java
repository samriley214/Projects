public class Problem2 {
    /**
     * This method calls a helper method to do tail recursion
     * @param s the string you want to pass through to the helper method
     * @return the result of the helper method
     */
    public static int countStrTR(String s){
        return helper(s, 0);
    }

    /**
     * Does the tail recursion to figure out how many times a substring appears inside a given string
     * @param s the given string
     * @param acc the accumulator
     * @return the amount of times the substring appears in the string
     */
    private static int helper(String s, int acc){
        if(!s.contains("str")){
            return acc;
        }
        else{
            return helper(s.substring(s.indexOf("str") + 3), acc + 1);
        }
    }
}
