package programing_practices;

// File name: BankSystemDemo.java

class BankAccount {
    // Static variable shared across all accounts
    static String bankName = "State Bank of India";
    private static int totalAccounts = 0;

    // Final variable - cannot be changed once assigned
    private final int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor using 'this' keyword to resolve ambiguity
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;  // 'this' removes ambiguity
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    // Instance method to display account details (with instanceof check)
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name (static): " + bankName);
            System.out.println("Account Number (final): " + accountNumber);
            System.out.println("Account Holder Name: " + accountHolderName);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Not a valid BankAccount object.");
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Public static method to get total accounts
    public static void getTotalAccounts() {
        System.out.println("Total Accounts Created: " + totalAccounts);
    }
}

// Main class
public class BankSystemDemo {
    public static void main(String[] args) {
        // Creating accounts
        BankAccount acc1 = new BankAccount(101, "Rahul Sharma", 5000);
        BankAccount acc2 = new BankAccount(102, "Aditi Sahu", 8000);

        // Displaying account details
        acc1.displayAccountDetails();
        System.out.println();
        acc2.displayAccountDetails();

        System.out.println();

        // Deposit and withdraw
        acc1.deposit(2000);
        acc1.withdraw(1000);
        System.out.println();

        // Display total accounts (static method)
        BankAccount.getTotalAccounts();
    }
}
