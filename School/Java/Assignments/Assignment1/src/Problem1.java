public class Problem1 {

    /**
     * This method takes a distance in gigameters and returns the equivalent distance in light seconds
     * @param gm the distance in gigameters that will get converted to light seconds
     * @return The distance converted from gigameters into light seconds
     */
    public static double gigameterToLightsecond(double gm){
        double ls = 299792458 * (0.000000001);
        return gm/ls;
    }
}
