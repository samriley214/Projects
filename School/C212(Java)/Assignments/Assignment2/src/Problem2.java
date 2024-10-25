public class Problem2 {
    /**
     * This method calculates the subfactorial of a number
     * @param x the number you want to find the subfactorial of
     * @return the subfactorial of x
     */
    public static int subfactorial(int x){
        if (x == 0){
            return 1;
        }
        else if (x == 1){
            return 0;
        }
        else{
            return (x-1) * (subfactorial(x-1) + subfactorial(x-2));
        }
    }
    /**
     * This method calculates the subfactorial of a number
     * @param x the number you want to find the subfactorial of
     * @return the subfactorial of x
     */
    public static int subfactorialTR(int x){
        return subfactorialTRH(x,1,0);
    }

    /**
     * This method calculates the subfactorial of x
     * @param x the number you want to find the subfactorial of
     * @param acc the previous result, starts at 1
     * @param acc2 the second previous result, starts at 0
     * @return the subfactorial of x
     */
    private static int subfactorialTRH(int x, int acc, int acc2){
        if (x == 0){
            return acc;
        }
        else if (x == 1){
            return acc2;
        }
        else{
            return subfactorialTRH(x-1, acc2, (x-1) * (acc + acc2));
        }
    }
    /**
     * This method calculates the subfactorial of a number
     * @param x the number you want to find the subfactorial of
     * @return the subfactorial of x
     */
    public static int subfactorialLoop(int x){
        int acc = 1, acc2 = 0;
        if(x == 0){
            return acc;
        }   
        while(x != 0){
            int temp = acc2;
            acc2 = (x - 1) * (acc + acc2);
            acc = temp;
            x -= 1;
        }
        return acc;
    }
}
