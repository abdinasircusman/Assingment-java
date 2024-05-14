import java.util.ArrayList;
import java.util.Date;

public class classAccount {
}

//public class Account {
//
//}
// Account class
class Account implements Comparable<Account> {
    private int accountNumber;
    private double balance;
    private String fullName;
    private Date dateCreated;
    private ArrayList<Transaction> transactionHistory;

    // Constructor
    public Account(int accountNumber, double balance, String fullName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.fullName = fullName;
        this.dateCreated = new Date();
        this.transactionHistory = new ArrayList<>();
    }

    // Getters and setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", amount));
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    // Check balance method
    public double checkBalance() {
        return balance;
    }

    // Transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction History for Account Number " + accountNumber + ":");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.toString());
        }
    }

    // Comparable interface implementation
    @Override
    public int compareTo(Account other) {
        return Double.compare(this.balance, other.balance);
    }
}

// Transaction class
class Transaction {
    private Date date;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Type: " + type + ", Amount: " + amount;
    }
}

// SavingsAccount class
class SavingsAccount extends Account {
    private double minimumBalance;

    public SavingsAccount(int accountNumber, double balance, String fullName, double minimumBalance) {
        super(accountNumber, balance, fullName);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        double withdrawalAmount = amount + 2.00; // Including transaction fee
        if (getBalance() - withdrawalAmount < minimumBalance) {
            throw new IllegalArgumentException("Withdrawal denied: Minimum balance requirement not met");
        }
        super.withdraw(withdrawalAmount);
    }

    // Apply monthly interest rate
    public void applyMonthlyInterestRate(double annualInterestRate) {
        double monthlyInterestRate = annualInterestRate / 12.0;
        double interest = getBalance() * monthlyInterestRate;
        deposit(interest);
    }
}


