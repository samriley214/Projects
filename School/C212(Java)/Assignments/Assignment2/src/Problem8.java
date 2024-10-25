public class Problem8 {
    /**
     * This method approximates the area of a given circle using the reimann summation
     * @param r the radius of the circle
     * @param delta the delta for the integral function
     * @return the area of the circle
     */
    public static double circleArea(double r, double delta){
        double sum = 0;
        for(int i = 0; i < (r/delta); i++){
            sum += f((i * delta),r) * delta;
        }
        return sum * 4;
    }

    /**
     * This method calculates f(xi) for the reimann summation
     * @param x the x value you want to test
     * @param r the radius of the circle for the formula
     * @return f(xi)
     */
    private static double f(double x, double r){
        return (Math.sqrt(Math.pow(r,2) - Math.pow(x,2)));
    }
}
