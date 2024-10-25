public class Problem2 {
    /**
     * this method computes the gpa based on a given letter grade
     * @param grade the given grade you want to test
     * @return the gpa of the given grade
     */
    public static String computeGpa(String grade){
        boolean plus = grade.contains("+");
        boolean minus = grade.contains("-");
        String letter = grade.substring(0,1);
        double gpa = 0;
        if (letter.equals("A")) { gpa = 4.0; }
        else if (letter.equals("B")) { gpa = 3.0; }
        else if (letter.equals("C")) { gpa = 2.0; }
        else if (letter.equals("D")) { gpa = 1.0; }
        else { gpa = 0.0; }
        if (!letter.equals("A") && !letter.equals("F")) { gpa = plus ? gpa + 0.3 : gpa; }
        if (!letter.equals("F")) { gpa = minus ? gpa - 0.3 : gpa; }
        return "" + gpa;
    }
}
