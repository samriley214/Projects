import java.util.PriorityQueue;

public class Problem2 {
    /**
     * This method finds the median of two integer arrays
     * @param A the first integer array
     * @param B the second integer array
     * @return the median of the two integer arrays
     */
    public static int median(int[] A, int[] B){
        PriorityQueue<Integer> holder = new PriorityQueue<>();
        for(int i = 0;i < 2; i++){
            if(i == 0) {
                for (int t : A) {
                    holder.add(t);
                }
            }
            else if(i == 1){
                for(int t: B){
                    holder.add(t);
                }
            }
        }
        int temp = holder.size();
        if(holder.size() % 2 == 0){
            for(int i = 0;i<temp/2;i++){
                holder.poll();
            }
            return holder.poll();
        }
        else{
            for(int i = 0;i<temp/2;i++){
                holder.poll();
            }
            return holder.poll();
        }
    }
}
