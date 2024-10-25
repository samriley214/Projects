import java.util.LinkedList;
import java.util.List;

class Vector {
    private final double A;
    private final double B;
    private final double C;
    Vector(double x, double y, double z) {
        this.A = x;
        this.B = y;
        this.C = z;
    }
    Vector(Point p1, Point p2){
        this.A = p2.getX() - p1.getX();
        this.B = p2.getY() - p1.getY();
        this.C = p2.getZ() - p1.getZ();
    }
    double getA(){
        return this.A;
    }
    double getB(){
        return this.B;
    }
    double getC(){
        return this.C;
    }
    List<Double> getVector(){
        List<Double> vector = new LinkedList<>();
        vector.add(this.A);
        vector.add(this.B);
        vector.add(this.C);
        return vector;
    }
    Vector unitVector(){
        double magnitude = Math.sqrt(Math.pow(this.A, 2) + Math.pow(this.B, 2) + Math.pow(this.C, 2));
        if (magnitude == 0){
            return new Vector(0,0,0);
        }
        else {
            return new Vector(this.A / magnitude, this.B / magnitude, this.C / magnitude);
            }
    }
    double dotProduct(Vector v){
        return this.A * v.getA() + this.B * v.getB() + this.C * v.getC();
    }
    Vector crossProduct(Vector v){
        Vector product = new Vector(this.B * v.getC() - this.getC() * v.getB(), this.C * v.getA() - this.getA() * v.getC(), this.A * v.getB() - this.getB() * v.getA());
        if(product.getA() == 0 && product.getB() == 0 && product.getC() == 0){
            return null;
        }
        else{
            return product;
        }
    }
}
