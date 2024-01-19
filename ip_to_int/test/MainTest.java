import converter.IpToInt32ConverterTest;
import util.ParseUtilsTest;

public final class MainTest {
    private final IpToInt32ConverterTest ipToInt32ConverterTest;
    private final ParseUtilsTest parseUtilsTest;

    public MainTest() {
        this.ipToInt32ConverterTest = new IpToInt32ConverterTest();
        this.parseUtilsTest = new ParseUtilsTest();
    }

    public static void main(String[] args) {
        new MainTest().runTests();
    }

    public void runTests() {
        ipToInt32ConverterTest.testAll();
        parseUtilsTest.testAll();
    }
}
