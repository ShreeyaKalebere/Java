import java.io.*;
import java.util.Scanner;

public class StudentDataIO {

    public static void main(String[] args) {
        String fileName = "studentData.txt";

        // Input from user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Weight (kg): ");
        float weight = scanner.nextFloat();

        System.out.print("Enter Height (cm): ");
        float height = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        // Write to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeUTF(name);
            dos.writeInt(age);
            dos.writeFloat(weight);
            dos.writeFloat(height);
            dos.writeUTF(city);
            dos.writeUTF(phone);
            System.out.println("\nData successfully written to file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Read from file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nReading data from file:");
            String readName = dis.readUTF();
            int readAge = dis.readInt();
            float readWeight = dis.readFloat();
            float readHeight = dis.readFloat();
            String readCity = dis.readUTF();
            String readPhone = dis.readUTF();

            System.out.println("Name: " + readName);
            System.out.println("Age: " + readAge);
            System.out.println("Weight: " + readWeight + " kg");
            System.out.println("Height: " + readHeight + " cm");
            System.out.println("City: " + readCity);
            System.out.println("Phone Number: " + readPhone);

        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
