public class Problem5 {
    /**
     * This method lexicographically compares two strings
     * @param s1 the first string you want to compare
     * @param s2 the second string you want to compare
     * @return 1 if s1 is bigger, -1 if s2 is bigger, 0 if they are the same
     */
    public static int compareTo(String s1, String s2){
        boolean diff = false;
        int counter = 0;
        s1.toLowerCase();
        s2.toLowerCase();
        if (s1.length() > s2.length()){
            return 1;
        }
        else if (s1.length() < s2.length()){
            return -1;
        }
        while(counter < s1.length()){
            if(s1.charAt(counter) > s2.charAt(counter)){
                return 1;
            }
            else if(s1.charAt(counter) < s2.charAt(counter)){
                return -1;
            }
            else{
                counter +=1;
            }
        }
        return 0;
    }
}
