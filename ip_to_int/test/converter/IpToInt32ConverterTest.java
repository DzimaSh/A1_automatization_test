package converter;

public class IpToInt32ConverterTest {
    private final IpToInt32Converter ipToInt32Converter;

    public IpToInt32ConverterTest() {
        this.ipToInt32Converter = new IpToInt32Converter();
    }

    public void testAll() {
        testInt32ToIp();
        testIpToInt32();
    }

    public void testInt32ToIp() {
        assert ipToInt32Converter.int32ToIp((int) 2149583360L).equals("128.32.10.0");
        assert ipToInt32Converter.int32ToIp(255).equals("0.0.0.255");
        System.out.println("int32ToIp passed all tests");
    }

    public void testIpToInt32() {
        assert ipToInt32Converter.ipToInt32("128.32.10.0") == -2145383936;
        assert ipToInt32Converter.ipToInt32("0.0.0.255") == 255;
        System.out.println("ipToInt32 passed all tests");
    }
}
