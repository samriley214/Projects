import java.util.ArrayList;
import java.util.Arrays;

public class Problem5 {
    /**
     * This method tokenizes a string at each instance of a given char
     * @param s the string you want to tokenize
     * @param d the char you want to tokenize at
     * @return an ArrayList that contains each part of the tokenized string
     */
    public static ArrayList<String> tokenize(String s, char d){
        ArrayList<String> holder = new ArrayList<>();
        int lastD = 0;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == d){
                if(i - lastD != 0) {
                    holder.add(slicer(s, lastD, i, d));
                }
                lastD = i;
            }
        }
        holder.add(slicer(s, lastD, s.length(), d));
        return holder;
    }

    /**
     * this method acts as a manual substring method
     * @param s the string you want to make a substring with
     * @param start the starting index of the substring
     * @param stop the ending index of the substring
     * @param d the delimiting char that is blacklisted
     * @return the newly cut string
     */
    private static String slicer(String s, int start, int stop, char d){
        String holder = "";
        for(int i = start; i < stop; i++){
            if(s.charAt(i) != d) {
                holder += s.charAt(i);
            }
        }
        return holder;
    }

}
