public class Problem3 {
    /**
     * This method replaces all the uppercase A's with B's
     * @param s the string you want to alter
     * @return the string with all A's turned to B's
     */
    public static String replaceAB(String s){
        if(!s.contains("A")){
            return s;
        }
        else{
            return replaceAB(s.replaceFirst("A","B"));
        }
    }
}
