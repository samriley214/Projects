public class Problem9 {
    /**
     * This method tests weather a point lies inside of given circle or not
     * @param cx the center of the circle's x coordinate
     * @param cy the center of the circle's y coordinate
     * @param r the radius of the circle
     * @param px the x coordinate of the point you want to try
     * @param py the y coordinate of the point you want to try
     * @return true if the point lies in the circle, false if not
     */
    public static boolean isInsideCircle(double cx, double cy, double r, double px, double py){
        return (Math.pow((px-cx), 2) + Math.pow((py-cy), 2) < Math.pow(r, 2));
    }
}
