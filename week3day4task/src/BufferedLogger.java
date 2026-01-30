import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BufferedLogger {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter log level (INFO/WARN/ERROR): ");
            String level = sc.nextLine();

            System.out.print("Enter message: ");
            String message = sc.nextLine();

            BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));

            String time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            bw.write(time + " " + level + " " + message);
            bw.newLine();

            bw.close();
            System.out.println("Log written with timestamp!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
