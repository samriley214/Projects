public class Problem3 {
    /**
     * This method returns the collatz sequence for a number
     * @param x the number you want the sequence for
     * @return the sequence of x
     */
    public static String collatz(int x){
        if(x == 1){
            return "1";
        }
        else {
            return collatzH(x);
        }
    }
    /**
     * This method returns the collatz sequence for a number
     * @param x the number you want the sequence for
     * @return the sequence of x
     */
    private static String collatzH(int x){
        String seq = "";
        if(x == 1){
            return seq + "1";
        }
        else if (x % 2 == 0){
            return seq + x + "," + collatzH(x/2);
        }
        else{
            return seq + x + "," + collatzH(3 * x + 1);
        }
    }
    /**
     * This method returns the collatz sequence for a number using tail recursion
     * @param x the number you want the sequence for
     * @return the sequence of x
     */
    public static String collatzTR(int x){
        return collatzTRH(x,"") + "1";
    }

    /**
     * This method does the work for the tail recursion method
     * @param x the number you want to use for the collatz sequence
     * @param seq the accumulator for the sequence
     * @return the sequence
     */
    private static String collatzTRH(int x, String seq) {
        if (x == 1){
            return seq;
        }
        else if (x % 2 == 0){
            return collatzTRH(x/2, seq + x + ",");
        }
        else{
            return collatzTRH(x * 3 + 1,seq + x + ",");
        }
    }

    /**
     * This method returns the collatz sequence for a number using a loop
     * @param x the number you want the sequence for
     * @return the sequence of x
     */
    public static String collatzLoop(int x){
        String seq = "";
        while(x != 1){
            seq += x + ",";
            if(x % 2 == 0){
                x /= 2;
            }
            else{
                x = x * 3 + 1;
            }
        }
        return seq + "1";
    }

}
