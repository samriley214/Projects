import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem8 {
    /**
     * This method evaluates a List of Strings that represents postfix notation
     * @param l the list of strings that contains the postfix information
     * @return the result of the operations
     */
    public static double postfixEvaluator(List<String> l){
        List<String> holder = new LinkedList<>();
        List<Integer> operands = new ArrayList<>();
        for(int i = 0;i < l.size() + 1; i++){
            if(l.get(i).equals("+") || l.get(i).equals("/") || l.get(i).equals("-") || l.get(i).equals("*")){
                l.addFirst("" + operate(l,i));
                l.remove(1);
                l.remove(1);
                l.remove(i - 1);
                if(i != l.size() + 1){
                    i = 0;
                }
            }
        }
        return Double.parseDouble(l.getFirst());
    }

    /**
     * This method slices the list and does the math of the postfix evaluator
     * @param l the list of strings
     * @param index the index of the operator that will be used
     * @return the result of the operation
     */
    private static double operate(List<String> l, int index){
        String operator = l.get(index);
        double[] nums = {Double.parseDouble(l.get(0)), Double.parseDouble(l.get(1))};
        switch (operator) {
            case "+" -> {
                return (double) nums[0] + nums[1];
            }
            case "-" -> {
                return (double) nums[0] - nums[1];
            }
            case "/" -> {
                return (double) nums[0] / nums[1];
            }
            case "*" -> {
                return (double) nums[0] * nums[1];
            }
        }
        return 0;
    }
}
