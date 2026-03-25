import java.sql.*;
import java.util.Scanner;

public class ATMService {

    Scanner sc = new Scanner(System.in);

    public void adminMenu() {
        Connection con = DBConnection.getConnection();

        while (true) {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. View ATM Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT total_cash_available FROM atm_machine WHERE id=1");
                        if (rs.next()) {
                            System.out.println("ATM Balance: " + rs.getDouble(1));
                        }
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        double deposit = sc.nextDouble();

                        PreparedStatement ps = con.prepareStatement(
                                "UPDATE atm_machine SET total_cash_available = total_cash_available + ? WHERE id=1");
                        ps.setDouble(1, deposit);
                        ps.executeUpdate();

                        System.out.println("Money Deposited");
                        break;

                    case 3:
                        System.out.print("Enter amount: ");
                        double withdraw = sc.nextDouble();

                        Statement st2 = con.createStatement();
                        ResultSet rs2 = st2.executeQuery("SELECT total_cash_available FROM atm_machine WHERE id=1");

                        if (rs2.next() && rs2.getDouble(1) >= withdraw) {
                            PreparedStatement ps2 = con.prepareStatement(
                                    "UPDATE atm_machine SET total_cash_available = total_cash_available - ? WHERE id=1");
                            ps2.setDouble(1, withdraw);
                            ps2.executeUpdate();

                            System.out.println("Withdraw Successful");
                        } else {
                            System.out.println("Insufficient ATM Balance");
                        }
                        break;

                    case 4:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}