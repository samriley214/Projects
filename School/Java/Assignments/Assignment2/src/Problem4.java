import java.sql.Array;

public class Problem4 {
    /**
     * This method turns strings into integers, ingnoring spaces, and leading zeros, and stops when the first letter after starting is hit
     * @param s the string you want to convert
     * @return the number derived from the string
     */
    public static int atoi(String s){
        String holder = "";
        boolean letter = false, negative = false;
        boolean start = !((s.charAt(0) < 49) || (s.charAt(0) > 57)) && s.charAt(0) != 45;
        int counter = 0;
        int result = 0;
        if(s.length() == 0){
            return 0;
        }
        while (!letter && counter < s.length()){
            boolean isLetter = (s.charAt(counter) < 49) || (s.charAt(counter) > 57) && s.charAt(counter) != 45;
            boolean isZero = s.charAt(counter) == 48;
            boolean isNum = s.charAt(counter) >= 49 && s.charAt(counter) <= 57;
            boolean isMinus = s.charAt(counter) == 45;
            if((isLetter && !isZero && !isMinus) && start){
                letter = true;
            }
            else if(isNum){
                start = true;
                if(counter > 0 && s.charAt(counter - 1) == 45){
                    negative = true;
                }
                holder += s.charAt(counter);
            }
            else if (isZero && start){
                holder += s.charAt(counter);
            }
            //System.out.println("Counter: " + counter + "| Char: " + (int) s.charAt(counter) + "(" + s.charAt(counter) + ")| Start: " + start + "| Letter: " + isLetter + "| Number: " + isNum + "| Zero: " + isZero);
            counter += 1;
        }
        for(int i = 0; i < holder.length(); i++){
            result += ((int) holder.charAt(i) - 48) * Math.pow(10,holder.length() - i - 1);
        }
        if(negative) {
            return -1 * result;
        }
        else{
            return result;
        }
    }
}
