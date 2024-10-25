public class Problem2 {
    /**
     * This method takes the amount of 5 different fruits at the grocery store and computes its total cost
     * @param a the number of apples
     * @param b the number of bananas
     * @param o the number of oranges
     * @param g the number of grapes
     * @param p the number of pineapples
     * @return the total cost of all the items in the list
     */
    static double grocery(int a, int b, int o, int g, int p){
        return (a * 0.59) + (b * 0.99) + (o * 0.45) + (g * 1.39) + (p * 2.24);
    }
}
