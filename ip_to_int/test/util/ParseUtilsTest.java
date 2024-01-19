package util;

public class ParseUtilsTest {

    public void testAll() {
        testIsNumeric();
    }

    public void testIsNumeric() {
        assert ParseUtils.isNumeric("12345");
        assert ParseUtils.isNumeric("-12345");
        assert !ParseUtils.isNumeric("12.345");
        assert !ParseUtils.isNumeric("abc");
        assert !ParseUtils.isNumeric(null);
        System.out.println("isNumeric passed all tests");
    }
}
