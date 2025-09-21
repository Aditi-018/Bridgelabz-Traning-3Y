package senario_based;

// File name: EWalletApp.java

// Interface for transferring money
interface Transferrable {
    void transferTo(User receiver, double amount);
}

// Base User class
class User {
    private String name;
    private Wallet wallet;

    public User(String name, double initialBalance, boolean referral) {
        this.name = name;
        this.wallet = new Wallet(this, initialBalance, referral);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }
}

// Wallet class
class Wallet implements Transferrable {
    private User owner;
    private double balance;

    // Constructor with optional referral bonus
    public Wallet(User owner, double initialBalance, boolean referral) {
        this.owner = owner;
        this.balance = initialBalance;
        if (referral) {
            this.balance += 50; // Referral bonus
        }
    }

    // Encapsulation: private balance, public getter
    public double getBalance() {
        return balance;
    }

    // Load money
    public void loadMoney(double amount) {
        balance += amount;
        System.out.println(owner.getName() + " loaded ₹" + amount + ". Current balance: ₹" + balance);
    }

    // Transfer money
    @Override
    public void transferTo(User receiver, double amount) {
        if (balance >= amount) {
            balance -= amount;
            receiver.getWallet().balance += amount; // direct update (inside class allowed)
            System.out.println(owner.getName() + " transferred ₹" + amount + " to " + receiver.getName());
        } else {
            System.out.println("❌ Transfer failed! Insufficient balance.");
        }
    }
}

// Personal Wallet with different transfer rules
class PersonalWallet extends Wallet {
    public PersonalWallet(User owner, double initialBalance, boolean referral) {
        super(owner, initialBalance, referral);
    }

    // Polymorphism: Transfer limit for personal wallet
    @Override
    public void transferTo(User receiver, double amount) {
        if (amount > 5000) {
            System.out.println("❌ Transfer limit exceeded for Personal Wallet (₹5000 max).");
        } else {
            super.transferTo(receiver, amount);
        }
    }
}

// Business Wallet with higher limits
class BusinessWallet extends Wallet {
    public BusinessWallet(User owner, double initialBalance, boolean referral) {
        super(owner, initialBalance, referral);
    }

    // Polymorphism: Higher transfer limit
    @Override
    public void transferTo(User receiver, double amount) {
        if (amount > 50000) {
            System.out.println("❌ Transfer limit exceeded for Business Wallet (₹50,000 max).");
        } else {
            super.transferTo(receiver, amount);
        }
    }
}

// Main Application
public class EWalletApp {
    public static void main(String[] args) {
        // Users
        User aditi = new User("Aditi", 1000, true);
        User rahul = new User("Rahul", 500, false);

        // Wallet types
        PersonalWallet aditiWallet = new PersonalWallet(aditi, aditi.getWallet().getBalance(), false);
        BusinessWallet rahulWallet = new BusinessWallet(rahul, rahul.getWallet().getBalance(), false);

        // Transactions
        aditiWallet.loadMoney(2000);
        aditiWallet.transferTo(rahul, 3000);
        rahulWallet.transferTo(aditi, 20000);

        System.out.println("\n💰 Final Balances:");
        System.out.println(aditi.getName() + ": ₹" + aditiWallet.getBalance());
        System.out.println(rahul.getName() + ": ₹" + rahulWallet.getBalance());
    }
}

