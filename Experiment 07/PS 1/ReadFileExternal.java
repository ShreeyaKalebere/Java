import java.io.*;

public class ReadFileExternal {

    public static void main(String[] args) {
        String filePath = "../sample.txt";

        File file = new File(filePath);

        try (
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)    
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); 
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
