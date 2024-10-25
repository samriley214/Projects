public class Problem7 {
    /**
     * This method computes the number of pairs that satisfy the equation (a^2 + b^2 + 1)/(ab)
     * @param n the integer that provides a ceiling to the equation
     * @return the number of pairs
     */
    public static int countPairs(int n){
        int counter = 0;
        for(int a = 1; a < n; a++){
            for(int b = 1; b < n; b++){
                if (((Math.pow(a,2) + Math.pow(b,2) + 1)/(a * b)) % 1 == 0 && a <= b){
                    counter += 1;
                }
            }
        }
        return counter;
    }
}
