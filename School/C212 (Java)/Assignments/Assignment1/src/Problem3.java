public class Problem3 {
    /**
     * this method takes in the length, width, and height of a pyramid and returns its area
     * @param l length of the pyramid
     * @param w width of the pyramid
     * @param h height of the pyramid
     * @return the area of the pyramid
     */
    static double pyramidSurfaceArea(double l, double w, double h){
        return l * w + (l * (Math.sqrt(Math.pow(w/2,2) + Math.pow(h,2))) + w * Math.sqrt(Math.pow(l/2,2) + Math.pow(h,2)));
    }
}
