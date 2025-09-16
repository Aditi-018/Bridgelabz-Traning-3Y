package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Interface for medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Patient class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract method for bill calculation
    public abstract double calculateBill();

    // Concrete method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Bill: $" + calculateBill());
    }

    // Encapsulation: getters and setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> records;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    // MedicalRecord interface methods
    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for InPatient " + getName() + ":");
        if(records.isEmpty()) {
            System.out.println("No records available.");
        } else {
            for(String r : records) {
                System.out.println("- " + r);
            }
        }
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    // MedicalRecord interface methods
    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for OutPatient " + getName() + ":");
        if(records.isEmpty()) {
            System.out.println("No records available.");
        } else {
            for(String r : records) {
                System.out.println("- " + r);
            }
        }
    }
}

// Main class to demonstrate polymorphism
public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient inPatient = new InPatient("P1001", "Alice", 30, 5, 200);
        OutPatient outPatient = new OutPatient("P2001", "Bob", 25, 50);

        // Add medical records
        inPatient.addRecord("Appendectomy performed");
        inPatient.addRecord("Post-surgery checkup done");
        outPatient.addRecord("Routine blood test");

        // Add patients to list
        patients.add(inPatient);
        patients.add(outPatient);

        // Polymorphism: display patient details and bills
        System.out.println("--- Patient Details ---");
        for(Patient p : patients) {
            p.getPatientDetails();
            if(p instanceof MedicalRecord) {
                ((MedicalRecord)p).viewRecords();
            }
            System.out.println();
        }
    }
}
