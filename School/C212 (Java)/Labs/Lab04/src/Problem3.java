public class Problem3 {
    /**
     * This method censors a given string
     * @param s the original string
     * @param c the word you want to censor
     * @return the censored string
     */
    public static String censor(String s, String c){
        int streak = 0;
        String holder = "";
        String holder2 = "";
        if(s.length() == 0|| c.length() == 0){
            return s;
        }
        for(int i = 0; i < s.length(); i++){
            holder2 += s.charAt(i);
            if(streak == c.length() - 1){
                streak = 0;
                for(int j = 0; j < holder2.length() - c.length();j++) {
                        holder += holder2.charAt(j);
                }
                for(int k = 0; k < c.length(); k++) {
                        holder += "*";
                }
                holder2 = "";
            }
            else if(s.charAt(i) == c.charAt(streak)){
                streak += 1;
            }
            else{
                streak = 0;
            }
            }
        int temp = holder.length();
        for(int i = 0; i < s.length() - temp; i++){
            holder += s.charAt(i + temp);
        }
        return holder;
        }
    }


