import java.io.*;

public class LogAnalyzer {
    public static void main(String[] args) {
        int total = 0, info = 0, warn = 0, error = 0;
        String longest = "";
        String firstTime = null;
        String lastTime = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("log.txt"));
            String line;

            while((line = br.readLine()) != null){
                total++;

                if(line.contains("INFO")) info++;
                if(line.contains("WARN")) warn++;
                if(line.contains("ERROR")) error++;

                if(line.length() > longest.length())
                    longest = line;

                String timestamp = line.substring(0, 19); // yyyy-mm-dd hh:mm:ss
                if(firstTime == null) firstTime = timestamp;
                lastTime = timestamp;
            }

            br.close();

            System.out.println("Total Logs: " + total);
            System.out.println("INFO: " + info);
            System.out.println("WARN: " + warn);
            System.out.println("ERROR: " + error);
            System.out.println("Longest Log: " + longest);
            System.out.println("First Timestamp: " + firstTime);
            System.out.println("Last Timestamp: " + lastTime);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
