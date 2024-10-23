public class Problem4 {
    /**
     * this function checks if a given year is a leap year
     * @param y the year you want to test
     * @return true if the year is a leap year, false if not
     */
    public static boolean isLeapYear(int y){
        if (y % 400 == 0){
            return true;
        }
        else if(y % 100 == 0){
            return false;
        }
        else if(y % 4 == 0){
            return true;
        }
        else{
            return false;
        }

    }
}
