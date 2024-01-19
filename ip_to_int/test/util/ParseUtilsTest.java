package util;

public class ParseUtilsTest {

    public void testAll() {
        testIsNumeric();
        testIsValidIp();
    }

    public void testIsNumeric() {
        assert ParseUtils.isNumeric("12345");
        assert ParseUtils.isNumeric("-12345");
        assert !ParseUtils.isNumeric("12.345");
        assert !ParseUtils.isNumeric("abc");
        assert !ParseUtils.isNumeric(null);
        System.out.println("isNumeric passed all tests");
    }

    public void testIsValidIp() {
        assert ParseUtils.isValidIp("128.32.10.0");
        assert ParseUtils.isValidIp("0.0.0.255");
        assert ParseUtils.isValidIp("255.255.255.255");
        assert !ParseUtils.isValidIp("256.0.0.0");
        assert !ParseUtils.isValidIp("abc");
        assert !ParseUtils.isValidIp(null);
        System.out.println("isValidIp passed all tests");
    }
}
