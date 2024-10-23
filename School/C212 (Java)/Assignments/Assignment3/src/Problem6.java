import java.util.ArrayList;
import java.util.HashMap;

public class Problem6 {
    /**
     * This method removes punctuation from a string and make a dictionary of the words and the amount of times they show up
     * @param s the string you want to make a dictionary of
     * @return the dictionary of the words and their counts
     */
    public static HashMap<String, Integer> wordCount(String s){
        String sPrime = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '(' && s.charAt(i) != ')' && s.charAt(i) != '*' && s.charAt(i) != '#' && s.charAt(i) != '!' && s.charAt(i) != ',' && s.charAt(i) != '.' && s.charAt(i) != '?' && s.charAt(i) != ';' && s.charAt(i) != '-' && s.charAt(i) != '&'){
                sPrime += s.charAt(i);
            }
        }
        ArrayList<String> depunc = tokenize(sPrime, ' ');
        HashMap<String, Integer> table = new HashMap<>();
        for(String x : depunc){
            if(!table.containsKey(x)){
                table.put(x, 1);
            }
            else{
                table.replace(x, table.get(x), table.get(x) + 1);
            }
        }
        return table;
    }

    /**
     * This method tokenizes a string at each instance of a given char
     * @param s the string you want to tokenize
     * @param d the char you want to tokenize at
     * @return an ArrayList that contains each part of the tokenized string
     */
    private static ArrayList<String> tokenize(String s, char d){
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
        return holder.toLowerCase();
    }
}
