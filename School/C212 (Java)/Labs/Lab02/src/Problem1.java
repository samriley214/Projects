public class Problem1 {
    /**
     *
     * @param f first name
     * @param l last name
     * @param y birth year
     * @return returns the first 5 digits of the last name concatinated with the first initial concatinated with the last two digits of the birth year
     */
    public static String userId(String f, String l, int y){
        f = f.substring(0,1);
        if (l.length() >= 5) {
            l = l.substring(0, 5);
        }
        y = y % 100;
        return l + f + y;
    }
}
