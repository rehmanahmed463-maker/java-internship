import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Database connection details
            String url = "jdbc:postgresql://localhost:5432/DAy1Task1";
            String user = "postgres";
            String password = "Rehman123"; // change if needed

            // 3. Establish connection
            con = DriverManager.getConnection(url, user, password);

            // 4. Print success message
            System.out.println("Connected successfully!");

        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } finally {
            // 5. Close all connections
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("Connections closed.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
