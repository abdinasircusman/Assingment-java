public class Mian {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Testing Account class
        Account account1 = new Account(604020, 8800.0, "abdinasir ");
        account1.deposit(800.0);
        account1.withdraw(400.0);
        System.out.println("Account Balance: $" + account1.checkBalance());
        account1.printTransactionHistory();

        // Testing SavingsAccount class
        SavingsAccount savingsAccount1 = new SavingsAccount(4455, 200.0, "suldan nasri", 500.0);
        savingsAccount1.applyMonthlyInterestRate(5.0);
        System.out.println("Savings Account Balance: $" + savingsAccount1.checkBalance());
    }

}



