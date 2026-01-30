import java.io.BufferedReader;
import java.io.FileReader;

public class FileCountDemo {
    public static void main(String[] args) {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("sample.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;

                // Count characters
                charCount += line.length();

                // Count words
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            br.close();

            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
