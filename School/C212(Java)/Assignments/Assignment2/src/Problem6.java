public class Problem6 {
    /**
     * This method sums all of the numbers in a string
     * @param s the given string you want to sum
     * @return the sum of the integers in the string
     */
    public static int strSumNums(String s){
        int sum = 0;
        String holder = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                holder += s.charAt(i);
            }
            else if(!holder.isEmpty()){
                sum += Integer.parseInt(holder);
                holder = "";
            }
        }
        if(!holder.isEmpty()) {
            sum += Integer.parseInt(holder);
        }
        return sum;
    }
}
