import java.util.*;
import java.io.*;

class FileAppend {
    public static void main(String args[]) {
        try {
            // Check if the file exists
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            String str;

            // Read and display the content of the file
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            // Asking user if they want to add data
            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to add data to the end of the file? (Yes/No)");
            String option = sc.next();

            // If user chooses "Yes", append data to the file
            if (option.equalsIgnoreCase("Yes")) {
                fr.close();
                FileWriter fw = new FileWriter(args[0], true);
                BufferedWriter bw = new BufferedWriter(fw);
                System.out.println("Enter the data to add to the file (type 'exit' to stop):");
                
                String str1;
                sc.nextLine();  // Consume the newline character left by next()
                do {
                    str1 = sc.nextLine();
                    if (!str1.equalsIgnoreCase("exit")) {
                        bw.write(str1);
                        bw.newLine();
                    }
                } while (!str1.equalsIgnoreCase("exit"));
                
                bw.close();
                fw.close();
                System.out.println("Data has been added to the file.");
            } else {
                System.out.println("No data added to the file.");
            }

        } catch (FileNotFoundException e) {
            // If the file doesn't exist, create a new file and write data
            try {
                System.out.println("File not found. Creating a new file...");
                FileWriter fw = new FileWriter(args[0]);
                BufferedWriter bw = new BufferedWriter(fw);
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter data to write in the new file (type 'exit' to stop):");
                
                String str1;
                do {
                    str1 = sc.nextLine();
                    if (!str1.equalsIgnoreCase("exit")) {
                        bw.write(str1);
                        bw.newLine();
                    }
                } while (!str1.equalsIgnoreCase("exit"));
                
                bw.close();
                fw.close();
                System.out.println("Data has been written to the new file.");
            } catch (IOException ex) {
                System.out.println("An error occurred while creating the file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the file.");
        }
    }
}
