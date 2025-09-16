package object_Modeling;

public class Customer {
    private String name;
    private int accountNumber;
    private double balance;

    // Constructor
    public Customer(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // View balance
    public void viewBalance() {
        System.out.println(name + "'s Account Number: " + accountNumber + ", Balance: $" + balance);
    }

    // Deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + "$ deposited. New balance: $" + balance);
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + "$ withdrawn. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Getters
    public String getName() {
        return name;
    }
}

