import calculator.SeriesCalculatorTest;

public class MainTest {

    private final SeriesCalculatorTest seriesCalculatorTest;

    public MainTest() {
        this.seriesCalculatorTest = new SeriesCalculatorTest();
    }

    public static void main(String[] args) {
        new MainTest().runTests();
    }

    public void runTests() {
        seriesCalculatorTest.testAll();
    }
}
