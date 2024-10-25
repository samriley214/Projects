public class Problem3 {
    /**
     * this function sorts three strings lexicographically
     * @param a the first string you want to sort
     * @param b the second string you want to sort
     * @param c the third string you want to sort
     * @return the three strings sorted
     */
    public static String sortThreeStrings(String a, String b, String c) {
        if (a.compareToIgnoreCase(b) < 0 && a.compareToIgnoreCase(c) < 0) {
            if (b.compareToIgnoreCase(c) < 0)
                return a + "," + b + "," + c;
            else {
                return a + "," + c + "," + b;
            }
        }
        else if (b.compareToIgnoreCase(a) < 0 && b.compareToIgnoreCase(c) < 0) {
            if (c.compareToIgnoreCase(a) < 0) {
                return b + "," + c + "," + a;
            }
            else {
                return b + "," + a + "," + c;
            }
        }
        else if (c.compareToIgnoreCase(a) < 0 && c.compareToIgnoreCase(b) < 0) {
            if (a.compareToIgnoreCase(b) < 0) {
                return c + "," + a + "," + b;
            }
            else {
                return c + "," + b + "," + a;
            }
        }
        return a + "," + b + "," + c;
    }
}

