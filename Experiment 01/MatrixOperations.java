import java.util.*;

class MatrixOperations {
    public static void main(String args[]) {
        int a[][] = new int[2][2];
        int b[][] = new int[2][2];
        int c[][] = new int[2][2];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First 2x2 Matrix: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("a[" + i + "][" + j + "] = ");
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Second 2x2 Matrix: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("b[" + i + "][" + j + "] = ");
                b[i][j] = sc.nextInt();
            }
        }

        // Menu
        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Multiplication");
        System.out.println("3. Transpose");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("\nAddition of Matrices:");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        c[i][j] = a[i][j] + b[i][j];
                        System.out.print(c[i][j] + "  ");
                    }
                    System.out.println();
                }
                break;

            case 2:
                System.out.println("\nMultiplication of Matrices:");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        c[i][j] = 0;
                        for (int k = 0; k < 2; k++) {
                            c[i][j] = c[i][j] + (a[i][k] * b[k][j]);
                        }
                        System.out.print(c[i][j] + "  ");
                    }
                    System.out.println();
                }
                break;

            case 3:
                System.out.println("\nTranspose of First Matrix:");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(a[j][i] + "  ");
                    }
                    System.out.println();
                }
                System.out.println("\nTranspose of Second Matrix:");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(b[j][i] + "  ");
                    }
                    System.out.println();
                }
                break;

            default:
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
        }
        sc.close();
    }
}
