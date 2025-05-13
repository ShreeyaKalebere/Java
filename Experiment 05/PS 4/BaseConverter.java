package math.convert;

public class BaseConverter {
    public static int binaryToDecimal(String b) {
        return Integer.parseInt(b, 2);
    }

    public static int octalToDecimal(String o) {
        return Integer.parseInt(o, 8);
    }

    public static int hexToDecimal(String h) {
        return Integer.parseInt(h, 16);
    }
}
