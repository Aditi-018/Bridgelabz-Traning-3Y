package senario_based;

// File name: LoanBuddy.java

import java.util.*;

// Interface for loan approval and EMI calculation
interface IApprovable {
    void approveLoan();
    double calculateEMI();
}

// Applicant class
class Applicant {
    private String name;
    private int creditScore; // encapsulated
    private double income;
    private double loanAmount;

    public Applicant(String name, int creditScore, double income, double loanAmount) {
        this.name = name;
        this.creditScore = creditScore;
        this.income = income;
        this.loanAmount = loanAmount;
    }

    public String getName() {
        return name;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getIncome() {
        return income;
    }

    public double getLoanAmount() {
        return loanAmount;
    }
}

// Base LoanApplication class
class LoanApplication implements IApprovable {
    protected Applicant applicant;
    protected String loanType;
    protected int termMonths;
    protected double interestRate; // annual rate in %
    private String loanStatus; // encapsulated, only internal changes

    // Constructor
    public LoanApplication(Applicant applicant, String loanType, int termMonths, double interestRate) {
        this.applicant = applicant;
        this.loanType = loanType;
        this.termMonths = termMonths;
        this.interestRate = interestRate;
        this.loanStatus = "Pending";
    }

    // Encapsulated method to set loan status
    protected void setLoanStatus(String status) {
        this.loanStatus = status;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    // EMI calculation formula: P * R * (1+R)^N / ((1+R)^N - 1)
    @Override
    public double calculateEMI() {
        double P = applicant.getLoanAmount();
        double R = (interestRate / 100) / 12; // monthly interest
        int N = termMonths;

        return P * R * Math.pow(1 + R, N) / (Math.pow(1 + R, N) - 1);
    }

    // Basic approval logic
    @Override
    public void approveLoan() {
        if (applicant.getCreditScore() >= 650 && applicant.getIncome() >= applicant.getLoanAmount() * 0.2) {
            setLoanStatus("Approved");
        } else {
            setLoanStatus("Rejected");
        }
    }

    public void showDetails() {
        System.out.println("Applicant: " + applicant.getName() +
                " | Loan Type: " + loanType +
                " | Loan Amount: $" + applicant.getLoanAmount() +
                " | Term: " + termMonths + " months" +
                " | Interest Rate: " + interestRate + "%" +
                " | Loan Status: " + getLoanStatus() +
                " | EMI: $" + String.format("%.2f", calculateEMI()));
    }
}

// HomeLoan class
class HomeLoan extends LoanApplication {

    public HomeLoan(Applicant applicant, int termMonths, double interestRate) {
        super(applicant, "Home Loan", termMonths, interestRate);
    }

    @Override
    public double calculateEMI() {
        // Home loans might have slightly lower EMI due to longer terms
        double P = applicant.getLoanAmount();
        double R = (interestRate / 100) / 12;
        int N = termMonths;
        return P * R * Math.pow(1 + R, N) / (Math.pow(1 + R, N) - 1) * 0.98; // 2% discount
    }

    @Override
    public void approveLoan() {
        // stricter approval: higher credit score
        if (applicant.getCreditScore() >= 700 && applicant.getIncome() >= applicant.getLoanAmount() * 0.25) {
            setLoanStatus("Approved");
        } else {
            setLoanStatus("Rejected");
        }
    }
}

// AutoLoan class
class AutoLoan extends LoanApplication {

    public AutoLoan(Applicant applicant, int termMonths, double interestRate) {
        super(applicant, "Auto Loan", termMonths, interestRate);
    }

    @Override
    public double calculateEMI() {
        // Auto loans might have slightly higher EMI
        double P = applicant.getLoanAmount();
        double R = (interestRate / 100) / 12;
        int N = termMonths;
        return P * R * Math.pow(1 + R, N) / (Math.pow(1 + R, N) - 1) * 1.02; // 2% extra
    }

    @Override
    public void approveLoan() {
        // moderate approval criteria
        if (applicant.getCreditScore() >= 650 && applicant.getIncome() >= applicant.getLoanAmount() * 0.15) {
            setLoanStatus("Approved");
        } else {
            setLoanStatus("Rejected");
        }
    }
}

// Main class
public class LoanBuddy {
    public static void main(String[] args) {
        Applicant alice = new Applicant("Alice", 720, 80000, 25000);
        Applicant bob = new Applicant("Bob", 640, 50000, 15000);
        Applicant charlie = new Applicant("Charlie", 680, 60000, 30000);

        // Loan Applications
        LoanApplication personalLoan = new LoanApplication(alice, "Personal Loan", 24, 12);
        LoanApplication homeLoan = new HomeLoan(bob, 120, 8);
        LoanApplication autoLoan = new AutoLoan(charlie, 36, 10);

        // Approve loans
        personalLoan.approveLoan();
        homeLoan.approveLoan();
        autoLoan.approveLoan();

        // Show details
        personalLoan.showDetails();
        homeLoan.showDetails();
        autoLoan.showDetails();
    }
}
