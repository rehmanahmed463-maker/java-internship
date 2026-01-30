import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AutoLogGenerator {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            for(int i=1; i<=25; i++)
                bw.write(LocalDateTime.now().format(f) + " INFO System running..." + i + "\n");

            for(int i=1; i<=15; i++)
                bw.write(LocalDateTime.now().format(f) + " WARN Low memory warning " + i + "\n");

            for(int i=1; i<=10; i++)
                bw.write(LocalDateTime.now().format(f) + " ERROR System failure " + i + "\n");

            bw.close();
            System.out.println("50 Logs Generated!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
