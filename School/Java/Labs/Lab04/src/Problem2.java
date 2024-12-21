public class Problem2 {
    /**
     * This method tells if a string contains abc in the middle of it
     * @param s the string you want to check
     * @return true if it does, false if it does not
     */
    public static boolean containsMiddleABC(String s) {
        if(s.length() == 0){
            return false;
        }
        else if(s.charAt(s.length()/2) == 65){
            return s.charAt(s.length() / 2 + 1) == 66 && s.charAt(s.length() / 2 + 2) == 67;
        }
        else if(s.charAt(s.length()/2) ==66){
            return s.charAt(s.length() / 2 + 1) == 67 && s.charAt(s.length() / 2 - 1) == 65;
        }
        else if(s.charAt(s.length()/2) ==67){
            return s.charAt(s.length() / 2 - 1) == 66 && s.charAt(s.length() / 2 - 2) == 65;
        }
            return false;
    }
}
