public class Lab01 {
    /**
     * This method return the sum of the squares of two integers
     * @param x first integer you want to sum
     * @param y second integer you want to sum
     * @return the sum of x and y
     */
    public static int SumOfSquares(int x, int y){
        return x*x + y*y;
    }

    /**
     * This method takes a degree in Celsius and converts it to Fahrenheit
     * @param c temperature in Celsius
     * @return temperatures in Fahrenheit
     */
    public static double CelsiusToFahrenheit(double c){
        return (c*1.8) + 32;
    }

    /**
     * This method takes a subtotal and returns the total amount with tax and tip
     * @param t the subtotal
     * @return the subtotal plus 6.75% tax and 20% tip
     */
    public static double billTotal(double t){
        return (t * 1.0675) * 1.2;
    }

    /**
     * This method takes two ordered pairs and returns the distance between the two
     * @param px the first x coordinate
     * @param py the first y coordinate
     * @param qx the second x coordinate
     * @param qy the second y coordinate
     * @return the distance between the two sets of points
     */
    public static double pointDistance(double px, double py, double qx, double qy){
        double a = qx - px;
        double b = qy - py;

        return Math.sqrt((a*a) + (b*b));
    }

    /**
     * This method takes in x and does some crazy math with it
     * @param x the x variable that you plug into the formula
     * @return returns t double after putting x through the formula
     */
    public static double crazyMath(double x){
        double FracBottom = (Math.log10(Math.abs(x))/Math.log10(2)) * (Math.log10(Math.abs(x))/Math.log10(4)) * Math.log(Math.abs(x));

        double FracWhole = (x * 3.14 * Math.cos(4 * 3.14 * x)) / (FracBottom);

        return Math.pow(1 - Math.exp(-x), (x * Math.exp(-x))) * FracWhole;
    }
}
