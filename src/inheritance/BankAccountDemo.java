package inheritance;

// File: BankAccountDemo.java

// Base Class
class BankAccount {
    String accountNumber;
    double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Common method
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    // To be overridden in subclasses
    public void displayAccountType() {
        System.out.println("Generic Bank Account");
    }
}

// Subclass 1: Savings Account
class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass 2: Checking Account
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}

// Subclass 3: Fixed Deposit Account
class FixedDepositAccount extends BankAccount {
    int depositTerm; // in months

    public FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Deposit Term: " + depositTerm + " months");
    }
}

// Main Class
public class BankAccountDemo {
    public static void main(String[] args) {
        // Create different types of accounts
        SavingsAccount sa = new SavingsAccount("SA123", 5000.0, 4.5);
        CheckingAccount ca = new CheckingAccount("CA456", 8000.0, 2000.0);
        FixedDepositAccount fda = new FixedDepositAccount("FD789", 20000.0, 24);

        // Display details
        System.out.println("---- Savings Account ----");
        sa.displayAccountDetails();
        sa.displayAccountType();

        System.out.println("\n---- Checking Account ----");
        ca.displayAccountDetails();
        ca.displayAccountType();

        System.out.println("\n---- Fixed Deposit Account ----");
        fda.displayAccountDetails();
        fda.displayAccountType();
    }
}
