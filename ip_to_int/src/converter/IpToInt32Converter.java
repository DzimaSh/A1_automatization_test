package converter;

public class IpToInt32Converter {
    /**
     * Converts a 32-bit integer into a string representation of an IPv4 address.
     *
     * @param ip The 32-bit integer representation of an IPv4 address.
     * @return A string representation of the IPv4 address in the format "x.x.x.x".
     */
    public String int32ToIp(int ip) {
        return ((ip >> 24) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                (ip & 0xFF);
    }

    /**
     * Converts a string representation of an IPv4 address into a 32-bit integer.
     *
     * @param ip The string representation of an IPv4 address in the format "x.x.x.x".
     * @return The 32-bit integer representation of the IPv4 address.
     */
    public int ipToInt32(String ip) {
        String[] octets = ip.split("\\.");
        return (Integer.parseInt(octets[0]) << 24) |
                (Integer.parseInt(octets[1]) << 16) |
                (Integer.parseInt(octets[2]) << 8) |
                Integer.parseInt(octets[3]);
    }
}
