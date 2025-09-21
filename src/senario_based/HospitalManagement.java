package senario_based;

// File: HospitalManagement.java

// Interface
interface Payable {
    double calculatePayment();
}

// Base Class
class Patient {
    private String name;
    private int age;
    private String medicalHistory;

    // Constructor for normal admission
    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overloaded Constructor for emergency admission
    public Patient(String name, int age, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    // Encapsulation (Getter/Setter)
    public String getName() { return name; }
    public void setMedicalHistory(String history) { this.medicalHistory = history; }

    // Polymorphism candidate
    public void displayInfo() {
        System.out.println("Patient: " + name + ", Age: " + age);
    }

    // Abstraction example (summary only, not raw data)
    public String getSummary() {
        return "Patient Summary: " + name + ", Age: " + age;
    }
}

// Inheritance Example - InPatient
class InPatient extends Patient {
    private int roomNumber;

    public InPatient(String name, int age, int roomNumber) {
        super(name, age);
        this.roomNumber = roomNumber;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Admitted in room: " + roomNumber);
    }
}

// Inheritance Example - OutPatient
class OutPatient extends Patient {
    private String appointmentDate;

    public OutPatient(String name, int age, String appointmentDate) {
        super(name, age);
        this.appointmentDate = appointmentDate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Appointment Date: " + appointmentDate);
    }
}

// Doctor Class
class Doctor {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("Doctor: " + name + ", Specialization: " + specialization);
    }
}

// Bill Class implementing Interface
class Bill implements Payable {
    private double treatmentCost;
    private double medicineCost;
    private double discount;

    public Bill(double treatmentCost, double medicineCost, double discount) {
        this.treatmentCost = treatmentCost;
        this.medicineCost = medicineCost;
        this.discount = discount;
    }

    // Operator usage for calculation
    @Override
    public double calculatePayment() {
        double total = treatmentCost + medicineCost;
        double discountAmount = total * (discount / 100);
        double tax = total * 0.05; // 5% tax
        return total - discountAmount + tax;
    }
}

// Main Class (Public) - Must be file name
public class HospitalManagement {
    public static void main(String[] args) {
        Patient p1 = new InPatient("Aditi", 22, 101);
        Patient p2 = new OutPatient("Rahul", 30, "21-Sep-2025");

        Doctor d1 = new Doctor("Dr. Mehta", "Cardiology");

        System.out.println("---- Patient & Doctor Info ----");
        p1.displayInfo();
        p2.displayInfo();
        d1.displayInfo();

        System.out.println("\n---- Billing ----");
        Bill bill = new Bill(5000, 2000, 10);
        System.out.println("Final Bill Amount: " + bill.calculatePayment());
    }
}

