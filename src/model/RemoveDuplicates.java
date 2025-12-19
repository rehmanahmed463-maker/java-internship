import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class RemoveDuplicates {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Aman");
        names.add("Neha");
        names.add("Aman");
        names.add("Rohit");
        names.add("Neha");
        names.add("Sahil");
        names.add("Aman");

        System.out.println("Original List:");
        System.out.println(names);

        Set<String> uniqueSet = new HashSet<>(names);

        System.out.println("\nSet with Unique Values:");
        System.out.println(uniqueSet);

        List<String> uniqueList = new ArrayList<>(uniqueSet);

        System.out.println("\nConverted Back to List:");
        System.out.println(uniqueList);
    }
}
