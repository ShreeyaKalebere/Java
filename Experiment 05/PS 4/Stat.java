package math;

public class Stat {
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int cube(int n) {
        return n * n * n;
    }
}
