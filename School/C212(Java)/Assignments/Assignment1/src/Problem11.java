public class Problem11 {
    /**
     * This method check weather or not a given string is a valid ip address
     * @param ip the given string
     * @return true if the string is a valid ip address, false if not
     */
    public static boolean isValidIpv4(String ip) {
        int counter = 0;
        int acounter = 0;
        String First = "", Second = "", Third = "", Fourth = "";
        String[] strings = {First, Second, Third, Fourth};
        while (counter < ip.length()) {
            String temp = "";
            temp += ip.charAt(counter);
            if (temp.equals(".")){
                acounter += 1;
            }
            else{
                strings[acounter] += temp;
            }
            counter += 1;
        }

        return (isNumeric(strings[0]) && Integer.valueOf(strings[0]) <= 255 && isNumeric(strings[1]) && Integer.valueOf(strings[1]) <= 255 && isNumeric(strings[2]) && Integer.valueOf(strings[2]) <= 255 && isNumeric(strings[3]) && Integer.valueOf(strings[3]) <= 255);
    }

    /**
     * Returns weather or not a string represents a number.
     * @param s - string input.
     * @return true if the string is parsable as a number, false otherwise.
     */
    static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
