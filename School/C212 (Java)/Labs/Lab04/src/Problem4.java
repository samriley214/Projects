public class Problem4 {
    /**
     * This method determines if an integers sum of digits divides into itself evenly
     * @param n the int you want to test
     * @return true if it divides evenly, false if not
     */
    public static boolean isSelfDividing(int n){
        int counter = 0;
        double temp = 0, temp2 = 0, temp3 = n;
        double sum = 0;
        while(n != 0 && counter < 100){
            temp = n;
            if(n % (10 * Math.pow(10,counter)) == 0){
                counter += 1;
            }
            n -= n % (10 * Math.pow(10, counter));
            temp2 =(temp - n)/(10 * Math.pow(10,counter - 1));
            sum += temp2;
        }
        return temp3 % sum == 0;
    }
}
