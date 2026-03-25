import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== ATM SYSTEM ====");
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            Connection con = DBConnection.getConnection();

            try {
                // Check admin
                PreparedStatement psAdmin = con.prepareStatement(
                        "SELECT * FROM atm_machine WHERE admin_pin=?");
                psAdmin.setInt(1, pin);
                ResultSet rsAdmin = psAdmin.executeQuery();

                if (rsAdmin.next()) {
                    new ATMService().adminMenu();
                    continue;
                }

                // Check user
                PreparedStatement psUser = con.prepareStatement(
                        "SELECT * FROM users WHERE user_pin=?");
                psUser.setInt(1, pin);
                ResultSet rsUser = psUser.executeQuery();

                if (rsUser.next()) {
                    int accNo = rsUser.getInt("account_number");
                    new UserService().userMenu(accNo);
                } else {
                    System.out.println("Invalid PIN");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}