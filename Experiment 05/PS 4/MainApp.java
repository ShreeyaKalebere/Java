import math.Stat;
import math.convert.DecimalConverter;
import math.convert.BaseConverter;

public class MainApp {
    public static void main(String[] args) {
        // Statistical operations
        System.out.println("Factorial of 5: " + Stat.factorial(5));
        System.out.println("Cube of 3: " + Stat.cube(3));

        // Decimal conversions
        int num = 25;
        System.out.println("Decimal " + num + " to Binary: " + DecimalConverter.toBinary(num));
        System.out.println("Decimal " + num + " to Octal: " + DecimalConverter.toOctal(num));
        System.out.println("Decimal " + num + " to Hex: " + DecimalConverter.toHex(num));

        // Base to Decimal
        System.out.println("Binary 11001 to Decimal: " + BaseConverter.binaryToDecimal("11001"));
        System.out.println("Octal 31 to Decimal: " + BaseConverter.octalToDecimal("31"));
        System.out.println("Hex 19 to Decimal: " + BaseConverter.hexToDecimal("19"));
    }
}
