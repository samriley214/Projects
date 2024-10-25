public class Problem10 {
    /**
     * This method sees how many candies you can fight inside a box
     * @param s the amount of small candies
     * @param l the amount of large candies
     * @param w the maximum weight of the box
     * @return the total number of small candies you can fit in the box
     */
    public static int fitCandy(int s, int l, int w){
        int counter = 0;
        if (w <= l || ((l * 5) + s) < w){
            return -1;
        }
        while (l > 0 && l * 5 <= w){
            l -= 1;
            w -= 5;
        }
        while (s > 0 && w > 0){
            s -= 1;
            counter += 1;
            w -= 1;
        }
        return counter;
    }
}
