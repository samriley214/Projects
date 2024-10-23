public class Problem4 {
    /**
     * This method modifies a string and removes the first and last letter
     * @param s the string you want to modify
     * @return the string without the first and last letter
     */
    public static String flStrip(String s){
        return s.substring(1,s.length()-1);
    }
}
