import java.util.List;

class VectorTest {
    public void tester(){
        Point p1 = new Point(1,2,3);
        Point p2 = new Point(10,-32,54);
        Point p3 = new Point(5,0,-9);
        Vector v1 = new Vector(-9,-34,-51);
        Vector v2 = new Vector(3,4,5);
        Vector uVector = new Vector(3/Math.sqrt(50), 4/Math.sqrt(50), 5/Math.sqrt(50));
        Vector dProduct = new Vector(-27,-136,-255);
        Vector cProduct = new Vector(34,-108,66);
        Vector v3 = new Vector(4,7,-7);
        Line l1 = new Line(p3, v3);
        double[] m1 = new double[]{5,4};
        double[] m2 = new double[]{0,7};
        double[] m3 = new double[]{-9,-7};
        double[][] matrix = new double[][]{m1,m2,m3};
            System.out.println("1: " + p1.getX());
            System.out.println("-32: " + p2.getY());
            System.out.println("54: " + p2.getZ());
            System.out.println(new double[]{-9,-34,-51} + ": " + v1.getVector());
            System.out.println(uVector + ": " +  v2.unitVector());
            System.out.println(dProduct + ": " + v1.dotProduct(v2));
            System.out.println(cProduct + ": " + v1.crossProduct(v2));
            System.out.println("x = 5 + 4t: " + l1.paramX());
            System.out.println("y = 7t: " + l1.paramY());
            System.out.println("z = -9 - 7t: " +  l1.paramZ());
            System.out.println(matrix + ": " + l1.parameterize());
    }
}