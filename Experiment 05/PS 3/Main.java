import MathOperations.FloorOperation;
import MathOperations.CeilOperation;
import MathOperations.RoundOperation;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        double n = sc.nextDouble();

        FloorOperation ob1 = new FloorOperation();
        CeilOperation ob2 = new CeilOperation();
        RoundOperation ob3 = new RoundOperation();

        System.out.println("Math Operations:  ");
        System.out.println("Original Number: " + n);
        System.out.println("Floor Value: " + ob1.FloorCal(n));
        System.out.println("Ceil Value: " + ob2.CeilCal(n));
        System.out.println("Round Value: " + ob3.RoundCal(n));
    }
}