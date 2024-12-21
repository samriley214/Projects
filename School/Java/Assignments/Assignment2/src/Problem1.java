public class Problem1 {
    /**
     * This method returns the GCD between two numbers
     * @param x the first number you want to check
     * @param y the second number you want to check
     * @return the GCD between x and y
     */
    public static int gcdTR(int x, int y){
        if(y > x){
            int temp = y;
            y = x;
            x = temp;
        }
        else if(x == 0){
            return y;
        }
        else if(x % y == 0){
            return y;
        }
        else if(y % x == 0){
            return x;
        }
        return gcdTR(y, x % y);
    }
    /**
     * This method returns the GCD between two numbers
     * @param x the first number you want to check
     * @param y the second number you want to check
     * @return the GCD between x and y
     */
    public static int gcdLoop(int x, int y){
        if(y > x){
            int temp = y;
            y = x;
            x = temp;
        }
        while(x % y != 0){
            y = x % y;
        }
        return y;
    }

}
