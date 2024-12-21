public class Problem1 {
    /**
     * This method returns the amount of times the given substring "str" appears in a string
     * @param s the given string you want to test
     * @return the amount of times the substring appears in the string
     */
    public static int countStr(String s){
        if(!s.contains("str")){
            return 0;
        }
        else{
            return (countStr(s.substring(s.indexOf("str") + 3))) + 1;
        }
    }
}
