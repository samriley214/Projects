public class Problem8 {
    /**
     * This method uses a conditional statement between P and Q and returns the result
     * @param P first bool
     * @param Q second bool
     * @return a conditional test between P and Q
     */
    static boolean cond(boolean P, Boolean Q){
        return !P || Q;
    }
    /**
     * This method uses a biconditional statement between P and Q and returns the result
     * @param P first bool
     * @param Q second bool
     * @return true if P equals Q, false if not
     */
    static boolean bicond(boolean P, Boolean Q){
        return P == Q;
    }
    /**
     * This method uses an and statement between P and Q and returns the result
     * @param P first bool
     * @param Q second bool
     * @return true if both P and Q are true, false if not
     */
    static boolean and(boolean P, Boolean Q){
        return P && Q;
    }
    /**
     * This method uses an or statement between P and Q and returns the result
     * @param P first bool
     * @param Q second bool
     * @return true if either P or Q are true, false if not
     */
    static boolean or(boolean P, Boolean Q){
        return P || Q;
    }
    /**
     * This method uses returns the inverse of P
     * @param P bool
     * @return the inverse of P
     */
    static boolean not(boolean P){
        return !P;
    }
}
