import java.io.*;
import java.util.Scanner;

public class SimpleLogger {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter log message: ");
            String msg = sc.nextLine();

            FileWriter fw = new FileWriter("log.txt", true); // append = true
            fw.write(msg + "\n");
            fw.close();

            System.out.println("Log written successfully!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
