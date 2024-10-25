public class Problem6 {
    /**
     * This method takes 3 integers, rounds them, and then adds them
     * @param x first integer
     * @param y second integer
     * @param z third integer
     * @return the sum of the rounded integers
     */
    public static int computeRoundSum(int x, int y, int z){
        int nums[] = {x, y, z};
        int temp2 = 0;
        for (int i = 0; i < 3; i++) {
          String temp = "" + nums[i];
          temp2 = Integer.parseInt(temp.substring(temp.length()-1));
          if(temp2 >= 5 && nums[i] >= 0){
              nums[0] += 10 - temp2;
          }
          else if (temp2 < 5 && nums[i] >= 0){
              nums[0] -= temp2;
          }
          else if(temp2 >= 5 && nums[i] < 0){
              nums[0] -= 10 - temp2;
          }
          else{
              nums[0] += temp2;
          }
        }
        return nums[0] + nums[1] + nums[2];
    }
}
