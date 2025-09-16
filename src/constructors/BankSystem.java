package constructors;

// File name: BankSystem.java

// Base class: BankAccount
class BankAccount {
    // Public, Protected, and Private members
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or Insufficient balance.");
        }
    }

    // Public method to check balance
    public double getBalance() {
        return balance;
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method to display details (demonstrating access to public and protected members)
    public void displayAccountDetails() {
        System.out.println("Account Number (public): " + accountNumber);
        System.out.println("Account Holder (protected): " + accountHolder);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {
        // Creating BankAccount object
        BankAccount acc1 = new BankAccount(101, "Rahul Sharma", 5000);
        acc1.deposit(2000);
        acc1.withdraw(1500);
        System.out.println("Balance: " + acc1.getBalance());

        System.out.println();

        // Creating SavingsAccount object
        SavingsAccount savAcc = new SavingsAccount(202, "Aditi Sahu", 10000, 5.5);
        savAcc.deposit(3000);
        savAcc.withdraw(2000);
        System.out.println("Balance: " + savAcc.getBalance());
        savAcc.displayAccountDetails();
    }
}

