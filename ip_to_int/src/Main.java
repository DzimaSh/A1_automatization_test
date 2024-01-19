import converter.IpToInt32Converter;
import util.ParseUtils;

public class Main {
    public static void main(String[] args) {
        new Main().start(args);
    }

    public void start(String[] args) {
        IpToInt32Converter converter = new IpToInt32Converter();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--help":
                    if (i == 0) {
                        printHelp();
                        return;
                    }
                    break;
                case "-32toi":
                    while (i + 1 < args.length && ParseUtils.isNumeric(args[i + 1])) {
                        int ipInt = Integer.parseInt(args[i + 1]);
                        System.out.println(converter.int32ToIp(ipInt));
                        i++;
                    }
                    break;
                case "-ito32":
                    while (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        String ipString = args[i + 1];
                        System.out.println(converter.ipToInt32(ipString));
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void printHelp() {
        System.out.println("""
        Usage: java Main [options] [arguments]

        Options:
          --help      Display this help message
          -32toi      Convert an int32 to an IP address
          -ito32      Convert an IP address to an int32

        Arguments:
          After -32toi, provide one or more int32 values
          After -ito32, provide one or more IP addresses
        """);
    }
}
