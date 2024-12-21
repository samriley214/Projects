public class Problem1 {
    /**
     * This method checks the divisibility of all the numbers from min to max, and returns a certain word related to its divisibility
     * @param min the start of the set of numbers you want to check
     * @param max the end of the set of numbers you want to check
     * @return the string[] with the words in it
     */
    public static String[] fizzBuzz(int min, int max){
    String[] holder = new String[max-min + 1];
    int counter = 0;
    for(int i = min;i < max + 1;i++){
        if(i % 3 == 0 && i % 5 == 0){
            holder[counter] = "FizzBuzz";
        }
        else if(i % 3 == 0 && i % 5 != 0){
            holder[counter] = "Fizz";
        }
        else if(i % 3 != 0 && i % 5 == 0){
            holder[counter] = "Buzz";
        }
        else{
            holder[counter] = i + "";
        }
        counter += 1;
    }
    return holder;
    }
}
