class Line {
    private final Point P;
    private final Vector V;
    Line(Point p, Vector v) {
        this.P = p;
        this.V = v;
    }
    String paramX(){
        String z = "x = ";
        if(this.P.getX() != 0 && this.V.getA() > 0){
            return z + this.P.getX() + " + " + this.V.getA() + "t";
        }
        else if(this.P.getX() != 0 && this.V.getA() < 0) {
            return z + this.P.getX() + " - " + this.V.getA() + "t";
        }
        else if(this.P.getX() == 0){
            return z + this.V.getA() + "t";
        }
        return z;
    }
    String paramY(){
        String z = "y = ";
        if(this.P.getY() != 0 && this.V.getB() > 0){
            return z + this.P.getY() + " + " + this.V.getB() + "t";
        }
        else if(this.P.getY() != 0 && this.V.getB() < 0) {
            return z + this.P.getY() + " - " + this.V.getB() + "t";
        }
        else if(this.P.getY() == 0){
            return z + this.V.getB() + "t";
        }
        return z;
    }
    String paramZ(){
        String z = "z = ";
        if(this.P.getZ() != 0 && this.V.getC() > 0){
            return z + this.P.getZ() + " + " + this.V.getC() + "t";
        }
        else if(this.P.getZ() != 0 && this.V.getC() < 0) {
            return z + this.P.getZ() + " - " + this.V.getC() + "t";
        }
        else if(this.P.getZ() == 0){
            return z + this.V.getC() + "t";
        }
        return z;
    }
    double[][] parameterize(){
        double[] xa = new double[]{this.P.getX(), this.V.getA()};
        double[] yb = new double[]{this.P.getY(), this.V.getB()};
        double[] zc = new double[]{this.P.getZ(), this.V.getC()};
        double[][] matrix = new double[][]{xa,yb,zc};
        return matrix;
    }
}
