
## 📄 File Descriptions

### Main.java
- Entry point of the application
- Handles PIN verification
- Routes to either admin or user menu based on PIN match
- Manages the main authentication loop

### DBConnection.java
- Manages MySQL database connection
- Uses JDBC driver for MySQL connectivity
- Connection details:
  - URL: `jdbc:mysql://localhost:3306/atm_system`
  - User: `root`
  - Returns connection object for database operations

### ATMService.java
- Handles admin operations
- Features:
  - View ATM balance
  - Deposit money to ATM
  - Withdraw money from ATM
  - Validates sufficient balance before withdrawal
  - Updates ATM balance in database

### UserService.java
- Handles user banking operations
- Features:
  - Deposit: Updates user balance and ATM balance, records transaction
  - Withdraw: Validates user balance and ATM balance before withdrawal
  - Balance Enquiry: Displays current account balance
  - Mini Statement: Shows last 5 transactions with date/time
  - All operations are recorded in transactions table

## 🗄️ Database Schema

### Required Tables:

**atm_machine**
```sql
CREATE TABLE atm_machine (
    id INT PRIMARY KEY,
    admin_pin INT,
    total_cash_available DOUBLE
); users

SQL
CREATE TABLE users (
    account_number INT PRIMARY KEY,
    user_pin INT,
    account_balance DOUBLE
);
transactions

SQL
CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_number INT,
    type VARCHAR(20),
    amount DOUBLE,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_number) REFERENCES users(account_number)
);
🚀 How to Run
Setup Database:

Create MySQL database named atm_system
Execute the SQL schema queries above
Insert sample data for admin and users
Configure Connection:

Update DBConnection.java with your MySQL credentials if different
Compile:

bash
javac *.java
Run:

bash
java Main
📝 Usage
For Users:
Run the application
Enter your user PIN when prompted
Select from menu options:
Deposit funds
Withdraw funds
Check balance
View transaction history
Exit
For Admin:
Run the application
Enter admin PIN when prompted
Select from admin menu options:
View ATM balance
Deposit money to ATM
Withdraw money from ATM
Exit
⚙️ Key Operations
Deposit Transaction:
Update user's account balance
Update ATM's total cash
Record transaction in transactions table
Withdraw Transaction:
Validate sufficient balance in user account
Validate sufficient cash in ATM
If valid: Update both balances and record transaction
If invalid: Display error message
Mini Statement:
Displays last 5 transactions ordered by date (newest first)
Shows transaction type, amount, and timestamp
🔐 Security Notes
Currently uses PIN-based authentication (can be enhanced with encryption)
Database credentials are hardcoded (should use configuration files in production)
Input validation could be improved for production use
SQL Injection protection: Uses PreparedStatements
🚨 Important Notes
This is a console-based educational project
For production use, implement proper security measures
Add comprehensive error handling and validation
Implement transaction rollback mechanisms
Consider adding account creation/deletion features
📧 Support
For issues or improvements, please contribute to the repository.

Author: Ragul777-star
Project Type: Java Console Application
License: Open Source
