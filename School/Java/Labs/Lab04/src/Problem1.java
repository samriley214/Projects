public class Problem1 {
    /**
     * This method returns the hyperfactorial of n
     * @param n the number you want to find the hyperfactorial of
     * @return the hyperfactorial of n
     */
    public static long hyperfactorialLoop(long n){
        long sum = 1;
        if(n == 0){
            return 1;
        }
        else{
            for(int i = 1; i < n; i++){
                sum *= (long) Math.pow(i,i);
            }
        }
        return sum;
    }
}
