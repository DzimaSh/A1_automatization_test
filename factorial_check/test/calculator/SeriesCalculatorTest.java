package calculator;

public class SeriesCalculatorTest {

    private final SeriesCalculator calculator;

    public SeriesCalculatorTest() {
        this.calculator = new SeriesCalculator();
    }

    public void testAll() {
        testCalculateSeries();
    }

    public void testCalculateSeries() {

        // Test with n = 3, precision = 2
        double result = calculator.calculateSeries(3, 2);
        assert result == 1.5 : "Test failed: Expected 1.5, but got " + result;

        // Test with n = 4, precision = 3
        result = calculator.calculateSeries(4, 3);
        assert result == 1.38 : "Test failed: Expected 1.38, but got " + result;

        // Test with n = 1, precision = 2
        try {
            result = calculator.calculateSeries(1, 2);
            assert false : "Test failed: Expected IllegalArgumentException for n < 2";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test with n = 3, precision = 1
        try {
            result = calculator.calculateSeries(3, 1);
            assert false : "Test failed: Expected IllegalArgumentException for precision <= 1";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        System.out.println("All tests passed!");
    }
}
