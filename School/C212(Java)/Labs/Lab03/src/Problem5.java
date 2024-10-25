public class Problem5 {

    /**
     * This method uses recursion to figure out the hyperfactorial of a number
     * @param n the number you want to find the hyperfactorial of
     * @return the hyperfactorial of n
     */
    public static long hyperfactorial(long n){
        if(n == 0){
            return 1;
        }
        else{
            return (long) (Math.pow(n,n) * hyperfactorial(n-1));
        }
    }

    /**
     * This method calls a helper function to do tail recursion to find the hyperfactorial of a number
     * @param n the number you want to pass through to the helper function
     * @return the result of the helper function
     */
    public static long hyperfactorialTR(long n){
        return helper(n,1);
    }

    /**
     * This method uses tail recursion to find the hyperfactorial of n
     * @param n the number you want to find the hyperfactorial of
     * @param acc accumulator
     * @return the hyperfactorial of n
     */
    private static long helper(long n, long acc){
        if (n == 0){
            return acc;
        }
        else{
            return helper(n-1, (long) ( acc * Math.pow(n,n)));
        }
    }
}
