package programing_practices;

// File: HospitalManagement.java

class Patient {
    // Static variable shared by all patients
    static String hospitalName = "City Care Hospital";
    static int totalPatients = 0;

    // Final variable for unique patient ID
    final int patientID;

    // Instance variables
    String name;
    int age;
    String ailment;

    // Constructor using 'this'
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;  // final variable initialized here
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++; // increment total patients when a new patient is created
    }

    // Static method to get total patients
    static void getTotalPatients() {
        System.out.println("Total patients admitted: " + totalPatients);
    }

    // Method to display details (with instanceof check)
    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("-------------------------");
        }
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        // Creating patients
        Patient p1 = new Patient(101, "Aditi Sahu", 21, "Fever");
        Patient p2 = new Patient(102, "Rohit Sharma", 30, "Fracture");

        // Display details
        p1.displayDetails();
        p2.displayDetails();

        // Show total patients
        Patient.getTotalPatients();
    }
}

