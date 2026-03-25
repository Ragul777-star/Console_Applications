import java.sql.*;
import java.util.Scanner;

public class UserService {

    Scanner sc = new Scanner(System.in);

    public void userMenu(int accNo) {

        Connection con = DBConnection.getConnection();

        while (true) {
            System.out.println("\n--- USER MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            try {
                switch (choice) {

                    // ================= DEPOSIT =================
                    case 1:
                        System.out.print("Enter amount: ");
                        double deposit = sc.nextDouble();

                        // update user balance
                        PreparedStatement ps1 = con.prepareStatement(
                                "UPDATE users SET account_balance = account_balance + ? WHERE account_number=?");
                        ps1.setDouble(1, deposit);
                        ps1.setInt(2, accNo);
                        ps1.executeUpdate();

                        // update ATM balance
                        PreparedStatement ps2 = con.prepareStatement(
                                "UPDATE atm_machine SET total_cash_available = total_cash_available + ? WHERE id=1");
                        ps2.setDouble(1, deposit);
                        ps2.executeUpdate();

                        // INSERT TRANSACTION
                        PreparedStatement t1 = con.prepareStatement(
                                "INSERT INTO transactions(account_number, type, amount) VALUES (?, 'Deposit', ?)");
                        t1.setInt(1, accNo);
                        t1.setDouble(2, deposit);
                        t1.executeUpdate();

                        System.out.println("✅ Deposit Successful");
                        break;

                    // ================= WITHDRAW =================
                    case 2:
                        System.out.print("Enter amount: ");
                        double withdraw = sc.nextDouble();

                        // check user balance
                        PreparedStatement checkUser = con.prepareStatement(
                                "SELECT account_balance FROM users WHERE account_number=?");
                        checkUser.setInt(1, accNo);
                        ResultSet rs = checkUser.executeQuery();

                        // check ATM balance
                        Statement st = con.createStatement();
                        ResultSet atmRs = st.executeQuery("SELECT total_cash_available FROM atm_machine WHERE id=1");

                        if (rs.next() && atmRs.next()) {
                            double userBal = rs.getDouble(1);
                            double atmBal = atmRs.getDouble(1);

                            if (userBal >= withdraw && atmBal >= withdraw) {

                                // update user
                                PreparedStatement ps3 = con.prepareStatement(
                                        "UPDATE users SET account_balance = account_balance - ? WHERE account_number=?");
                                ps3.setDouble(1, withdraw);
                                ps3.setInt(2, accNo);
                                ps3.executeUpdate();

                                // update ATM
                                PreparedStatement ps4 = con.prepareStatement(
                                        "UPDATE atm_machine SET total_cash_available = total_cash_available - ? WHERE id=1");
                                ps4.setDouble(1, withdraw);
                                ps4.executeUpdate();

                                // INSERT TRANSACTION
                                PreparedStatement t2 = con.prepareStatement(
                                        "INSERT INTO transactions(account_number, type, amount) VALUES (?, 'Withdraw', ?)");
                                t2.setInt(1, accNo);
                                t2.setDouble(2, withdraw);
                                t2.executeUpdate();

                                System.out.println("✅ Withdraw Successful");
                            } else {
                                System.out.println("❌ Insufficient Balance");
                            }
                        }
                        break;

                    // ================= BALANCE =================
                    case 3:
                        PreparedStatement ps5 = con.prepareStatement(
                                "SELECT account_balance FROM users WHERE account_number=?");
                        ps5.setInt(1, accNo);
                        ResultSet rs5 = ps5.executeQuery();

                        if (rs5.next()) {
                            System.out.println("💰 Balance: " + rs5.getDouble(1));
                        }
                        break;

                    // ================= MINI STATEMENT =================
                    case 4:
                        PreparedStatement ps6 = con.prepareStatement(
                                "SELECT * FROM transactions WHERE account_number=? ORDER BY date DESC LIMIT 5");
                        ps6.setInt(1, accNo);
                        ResultSet rs6 = ps6.executeQuery();

                        System.out.println("\n--- MINI STATEMENT (Last 5 Transactions) ---");

                        while (rs6.next()) {
                            System.out.println(
                                    rs6.getString("type") + " | " +
                                    rs6.getDouble("amount") + " | " +
                                    rs6.getTimestamp("date")
                            );
                        }
                        break;

                    case 5:
                        return;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}