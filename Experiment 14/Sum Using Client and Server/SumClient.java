import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SumClient {
    public static void main(String args[]) {
        try {
            Socket s = new Socket("127.0.0.1", 1520);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            dos.writeInt(num1);
            dos.writeInt(num2);

            int sum = dis.readInt();
            System.out.println("Sum received from server: " + sum);

            s.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
