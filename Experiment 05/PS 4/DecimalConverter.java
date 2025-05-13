package math.convert;

public class DecimalConverter {
    public static String toBinary(int n) {
        return Integer.toBinaryString(n);
    }

    public static String toOctal(int n) {
        return Integer.toOctalString(n);
    }

    public static String toHex(int n) {
        return Integer.toHexString(n).toUpperCase();
    }
}
