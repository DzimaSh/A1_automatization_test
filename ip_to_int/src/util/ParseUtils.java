package util;

import java.util.Objects;

public class ParseUtils {

    /**
     * Checks if a string can be parsed as an integer.
     *
     * @param strNum The string to check.
     * @return true if the string can be parsed as a long, false otherwise.
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Checks if a string is a valid IPv4 address.
     *
     * @param ip The string to check.
     * @return true if the string is a valid IPv4 address, false otherwise.
     */
    public static boolean isValidIp(String ip) {
        if (Objects.isNull(ip)) {
            return false;
        }

        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            int value;
            try {
                value = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                return false;
            }
            if (value < 0 || value > 255) {
                return false;
            }
        }
        return true;
    }
}
