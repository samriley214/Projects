public class Problem5 {
    /**
     * This method check if each digit of an integer can divide into itself evenly
     * @param n the int you want to check
     * @return true if it can, false if not
     */
    public static boolean allSelfDividing(int n){
        int counter = 0;
        double temp = 0, temp2 = 0, temp3 = n;
        double sum = 0;
        while(n != 0){
            temp = n;
            if(n % 10 == 0){
                return false;
            }
            if(n % (10 * Math.pow(10,counter)) == 0){
                counter += 1;
            }
            n -= n % (10 * Math.pow(10, counter));
            temp2 =(temp - n)/(10 * Math.pow(10,counter - 1));
            if(temp2 == 0){
                return false;
            }
            if(temp3 % temp2 == 0){
                return true;
            }
        }
        return false;
    }
}
