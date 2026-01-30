import java.util.*;

public class Week2day4task {

    public static void main(String[] args) {

        System.out.println("------ COLLECTION SCENARIO TASK ------\n");

        // 1. Attendance List -> Maintain order
        System.out.println("1) Attendance List (Maintain Order)");
        List<String> attendanceList = new ArrayList<>();
        attendanceList.add("Rahul");
        attendanceList.add("Aman");
        attendanceList.add("Sneha");
        System.out.println("Attendance: " + attendanceList);
        System.out.println();

        // 2. Remove duplicate exam submissions
        System.out.println("2) Remove Duplicate Exam Submissions");
        Set<String> examSubmissions = new HashSet<>();
        examSubmissions.add("Sheet1");
        examSubmissions.add("Sheet1");
        examSubmissions.add("Sheet2");
        System.out.println("Unique Submissions: " + examSubmissions);
        System.out.println();

        // 3. College timetable -> sorted order
        System.out.println("3) College Timetable (Sorted by Time)");
        TreeSet<String> timeTable = new TreeSet<>();
        timeTable.add("09:00 - Java");
        timeTable.add("10:00 - DBMS");
        timeTable.add("08:00 - Networking");
        System.out.println("Timetable: " + timeTable);
        System.out.println();

        // 4. Student Roll No Lookup
        System.out.println("4) Student Roll Number Lookup");
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(101, "Rahul");
        studentMap.put(102, "Sneha");
        studentMap.put(103, "Aman");
        System.out.println("Student with Roll 102: " + studentMap.get(102));
        System.out.println();

        // 5. Print Queue
        System.out.println("5) Print Queue (FIFO)");
        Queue<String> printQueue = new LinkedList<>();
        printQueue.add("Document1");
        printQueue.add("Document2");
        printQueue.add("Document3");
        System.out.println("Printing: " + printQueue.poll());
        System.out.println("Remaining Queue: " + printQueue);
        System.out.println();

        // 6. Browser History using Stack
        System.out.println("6) Browser History (Stack - LIFO)");
        Stack<String> browserHistory = new Stack<>();
        browserHistory.push("Google");
        browserHistory.push("YouTube");
        browserHistory.push("Instagram");
        System.out.println("Back To: " + browserHistory.pop());
        System.out.println("Current History: " + browserHistory);
        System.out.println();

        // 7. Leaderboard scores sorted
        System.out.println("7) Leaderboard (Sorted Scores)");
        TreeSet<Integer> leaderboard = new TreeSet<>();
        leaderboard.add(90);
        leaderboard.add(80);
        leaderboard.add(95);
        System.out.println("Scores Low to High: " + leaderboard);
        System.out.println("Scores High to Low: " + leaderboard.descendingSet());
        System.out.println();

        // 8. Ecommerce Product List
        System.out.println("8) Ecommerce Product List");
        List<String> products = new ArrayList<>();
        products.add("Mobile");
        products.add("Laptop");
        products.add("Headphones");
        System.out.println("Products: " + products);
        System.out.println();

        // 9. Cache maintaining insertion order
        System.out.println("9) Cache (Insertion Order Preserved)");
        LinkedHashMap<Integer, String> cache = new LinkedHashMap<>();
        cache.put(1, "Data-A");
        cache.put(2, "Data-B");
        cache.put(3, "Data-C");
        System.out.println("Cache: " + cache);
        System.out.println();

        // 10. Priority Task Management
        System.out.println("10) Priority Based Task Handling");
        PriorityQueue<Integer> priorityTasks = new PriorityQueue<>();
        priorityTasks.add(3);
        priorityTasks.add(1);
        priorityTasks.add(2);
        System.out.println("Highest Priority Task: " + priorityTasks.poll());
        System.out.println("Remaining Tasks: " + priorityTasks);
        System.out.println();

        System.out.println("------ TASK COMPLETED SUCCESSFULLY ------");
    }
}
