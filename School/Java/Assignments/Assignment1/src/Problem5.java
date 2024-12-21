public class Problem5 {
    /**
     * This method generates a username x from an email address in the form x@y.z
     * @param email the given email
     * @return the username
     */
    public static String cutUsername(String email){
        return email.substring(0,email.indexOf("@"));
    }
}
