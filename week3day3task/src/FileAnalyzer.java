import java.io.*;
import java.util.*;

public class FileAnalyzer {
    public static void main(String[] args) {

        String longest = "";
        String shortest = null;
        Set<String> uniqueWords = new HashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String w : words) {
                    w = w.replaceAll("[^a-zA-Z]", ""); // remove punctuation
                    if (w.isEmpty()) continue;

                    uniqueWords.add(w);

                    if (w.length() > longest.length())
                        longest = w;

                    if (shortest == null || w.length() < shortest.length())
                        shortest = w;
                }
            }

            br.close();

            System.out.println("Longest Word: " + longest);
            System.out.println("Shortest Word: " + shortest);
            System.out.println("Unique Words: " + uniqueWords.size());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
