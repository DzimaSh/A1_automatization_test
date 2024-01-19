package util;

public class ParseUtils {

    /**
     * Checks if a string can be parsed as an integer.
     *
     * @param strNum The string to check.
     * @return true if the string can be parsed as an integer, false otherwise.
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
