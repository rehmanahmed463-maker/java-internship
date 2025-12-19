import java.util.*;

public class removeduplicates {

    public static void main(String[] args) {

        // 1. Store values in List
        List<String> names = new ArrayList<>();
        names.add("Aman");
        names.add("Neha");
        names.add("Aman");
        names.add("Rohit");
        names.add("Neha");
        names.add("Sahil");
        names.add("Aman");

        // Display original list
        System.out.println("Original List:");
        System.out.println(names);

        // 2. Remove duplicates using HashSet
        Set<String> uniqueSet = new HashSet<>(names);

        // Display set
        System.out.println("\nUnique Set:");
        System.out.println(uniqueSet);

        // 4. Convert back to List (optional)
        List<String> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println("\nConverted back to List:");
        System.out.println(uniqueList);
    }
}
