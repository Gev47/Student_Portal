import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/portal_db";
        String user = "admin";
        String password = "admin";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Connected to the database!");
        } catch (SQLException e) {
            System.out.println("❌ Connection failed:");
            e.printStackTrace();
        }
    }
}
