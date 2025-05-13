import java.io.FileReader;
import java.io.IOException;

public class FileStats {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("sample2.txt"); // File to read

        int ch;
        int vowelCount = 0;
        int wordCount = 0;
        int aCount = 0;
        boolean inWord = false;

        while ((ch = fr.read()) != -1) {
            char c = (char) ch;

            if ("aeiouAEIOU".indexOf(c) != -1) {
                vowelCount++;
            }

            if (c == 'a' || c == 'A') {
                aCount++;
            }

            if (Character.isWhitespace(c)) {
                inWord = false;
            } else if (!inWord) {
                wordCount++;
                inWord = true;
            }
        }

        fr.close();

        System.out.println("Total number of vowels: " + vowelCount);
        System.out.println("Total number of words: " + wordCount);
        System.out.println("Total occurrences of 'a': " + aCount);
    }
}
