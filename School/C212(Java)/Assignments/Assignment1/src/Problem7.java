public class Problem7 {
    /**
     * This method checks is any of the three given numbers are 20 or more apart
     *
     * @param x the first int you want to check
     * @param y the second int you want to check
     * @param z the third int you want to check
     * @return true if any are less than 20 apart, false if not
     */
    public static boolean lessThan20(int x, int y, int z) {
        return (Math.abs(x - y) < 20 || Math.abs(x - z) < 20);
    }
}
