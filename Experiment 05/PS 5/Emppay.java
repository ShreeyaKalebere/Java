import java.util.Scanner;
import employee.Emp;

public class Emppay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID (int): ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Category (e.g. HR): ");
        String cat = sc.nextLine();

        System.out.print("Enter Basic Pay (double): ");
        double bp = sc.nextDouble();

        Emp e = new Emp();
        e.setData(name, id, cat, bp);
        e.calculate();
        e.display();

        sc.close();
    }
}
