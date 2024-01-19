import calculator.SeriesCalculator;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1 || args[0].equals("--help")) {
            printUsage();
            return;
        }

        new Main().start(args);
    }

    private void start(String[] args) {
        SeriesCalculator calculator = new SeriesCalculator();

        int n;
        int precision = 6; // default precision

        try {
            n = Integer.parseInt(args[0]);
            if (args.length > 1) {
                precision = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Both n and precision must be integers.");
            return;
        }

        try {
            System.out.println(calculator.calculateSeries(n, precision));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printUsage() {
        System.out.println("""
        Usage: java Main <n> [precision]
        
        <n>: The number of terms in the series.
        [precision]: Optional. The precision for the division operation. Default is 6.
        """);
    }
}
