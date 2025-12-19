import java.util.*;

public class StudentDuplicateRemove {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        // Add duplicate students
        students.add(new Student(1, "Aman", "CS"));
        students.add(new Student(2, "Neha", "IT"));
        students.add(new Student(1, "Aman", "CS"));
        students.add(new Student(3, "Rohit", "CS"));
        students.add(new Student(2, "Neha", "IT"));

        System.out.println("Original Student List:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Remove duplicates using HashSet
        Set<Student> uniqueStudents = new HashSet<>(students);

        System.out.println("\nAfter Removing Duplicates:");
        for (Student s : uniqueStudents) {
            System.out.println(s);
        }
    }
}

