public class PrimeCheck {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a number as a command-line argument.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int flag = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }

        System.out.println(flag == 0 ? "Yes, it is Prime" : "Not a Prime Number");
    }
}