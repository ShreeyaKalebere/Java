import java.util.Scanner;

class SortNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String names[] = new String[10];

        System.out.println("Enter 10 names: ");
        for (int i = 0; i < 10; i++) {
            names[i] = sc.nextLine();
        }

        for (int i = 0; i < 10 - 1; i++) {
            for (int j = 0; j < 10 - i - 1; j++) { 
                if (names[j].compareTo(names[j + 1]) > 0) {
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }

        System.out.println("\nNames in Alphabetical Order:");
        for (int i = 0; i < 10; i++) {
            System.out.println(names[i]);
        }
    }
}
