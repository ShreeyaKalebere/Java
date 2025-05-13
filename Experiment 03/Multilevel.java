import java.util.Scanner;

class Student{
    int roll_no;
}

class Test extends Student{
    double sub1, sub2;

}

class Result extends Test{
    void display(int roll_no, double sub1, double sub2){
        System.out.println("\nDisplaying Details: ");
        System.out.println("Roll No. is: " + roll_no);
        System.out.println("Subject 1 Marks: " + sub1);
        System.out.println("Subject 2 Marks: " + sub2);
        System.out.println("Percentage: " + (sub1+sub2)*0.5);
    }
}

public class Multilevel{
    public static void main(String[] args) {
        Result r1 = new Result();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll No.: ");
        r1.roll_no = sc.nextInt();

        System.out.print("Enter Subject 1 Marks(Out of 100): ");
        r1.sub1 = sc.nextDouble();

        System.out.print("Enter Subject 2 Marks(Out of 100): ");
        r1.sub2 = sc.nextDouble();

        r1.display(r1.roll_no, r1.sub1, r1.sub2);
    }
}