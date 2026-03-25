import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static final String URL = "jdbc:mysql://localhost:3306/atm_system";
    static final String USER = "root";
    static final String PASSWORD = "DhoniRaina09@";

    public static Connection getConnection() {
        try {
            // ✅ Load driver (important)
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            System.out.println("Database Connection Failed");
            e.printStackTrace(); // 🔥 VERY IMPORTANT
            return null;
        }
    }
}