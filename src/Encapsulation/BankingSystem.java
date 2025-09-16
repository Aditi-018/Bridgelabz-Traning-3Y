package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Interface for loanable accounts
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Abstract method for interest calculation
    public abstract double calculateInterest();

    // Encapsulation: getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {  // protected to allow subclass modifications
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest: $" + calculateInterest());
        System.out.println();
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate; // e.g., 4% annual

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    // Loanable interface methods
    @Override
    public void applyForLoan(double amount) {
        System.out.println("SavingsAccount: Loan application for $" + amount + " submitted.");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2; // eligible up to 2x balance
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest on current accounts
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}

// Main class to demonstrate polymorphism
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        // Create accounts
        SavingsAccount sa = new SavingsAccount("SAV1001", "Alice", 5000, 4);
        CurrentAccount ca = new CurrentAccount("CUR2001", "Bob", 3000, 1000);

        // Deposit and withdraw
        sa.deposit(500);
        ca.withdraw(200);

        // Polymorphism: process all accounts
        accounts.add(sa);
        accounts.add(ca);

        System.out.println("\n--- Account Details ---");
        for (BankAccount acc : accounts) {
            acc.displayDetails();
        }

        // Loan demonstration
        System.out.println("--- Loan Eligibility ---");
        if (sa instanceof Loanable) {
            Loanable loanable = (Loanable) sa;
            loanable.applyForLoan(2000);
            System.out.println("Loan Eligibility: $" + loanable.calculateLoanEligibility());
        }
    }
}
