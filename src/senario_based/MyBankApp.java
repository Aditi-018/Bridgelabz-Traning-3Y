package senario_based;

// File name: MyBankApp.java

// Interface for transactions
interface ITransaction {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

// Base Account class
abstract class Account implements ITransaction {
    private String accountNumber;
    private double balance; // encapsulated

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    // Encapsulation: only modify balance via methods
    protected void addBalance(double amount) {
        balance += amount;
    }

    protected boolean deductBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Polymorphic method for interest calculation
    public abstract double calculateInterest();

    @Override
    public void checkBalance() {
        System.out.println("Account " + accountNumber + " Balance: ₹" + balance);
    }
}

// Savings Account
class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 4.0; // 4% annual

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE / 100;
    }

    @Override
    public void deposit(double amount) {
        addBalance(amount);
        System.out.println("₹" + amount + " deposited to Savings Account " + getAccountNumber());
    }

    @Override
    public void withdraw(double amount) {
        if (deductBalance(amount)) {
            System.out.println("₹" + amount + " withdrawn from Savings Account " + getAccountNumber());
        } else {
            System.out.println("❌ Insufficient balance in Savings Account " + getAccountNumber());
        }
    }
}

// Current Account
class CurrentAccount extends Account {
    private static final double INTEREST_RATE = 2.0; // 2% annual
    private static final double OVERDRAFT_LIMIT = 10000; // allowed negative balance

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }

    public CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE / 100;
    }

    @Override
    public void deposit(double amount) {
        addBalance(amount);
        System.out.println("₹" + amount + " deposited to Current Account " + getAccountNumber());
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= -OVERDRAFT_LIMIT) {
            deductBalance(amount);
            System.out.println("₹" + amount + " withdrawn from Current Account " + getAccountNumber());
        } else {
            System.out.println("❌ Exceeded overdraft limit in Current Account " + getAccountNumber());
        }
    }
}

// Main Bank Application
public class MyBankApp {
    public static void main(String[] args) {
        // Create accounts
        Account savings = new SavingsAccount("SAV123", 5000);
        Account current = new CurrentAccount("CUR456", 2000);

        // Perform transactions
        savings.deposit(2000);
        savings.withdraw(1000);
        savings.checkBalance();
        System.out.println("Interest for Savings Account: ₹" + savings.calculateInterest());

        System.out.println();

        current.deposit(5000);
        current.withdraw(8000); // allowed due to overdraft
        current.withdraw(10000); // exceeds overdraft
        current.checkBalance();
        System.out.println("Interest for Current Account: ₹" + current.calculateInterest());
    }
}
