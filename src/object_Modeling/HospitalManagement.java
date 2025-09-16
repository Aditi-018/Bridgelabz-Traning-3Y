package object_Modeling;

import java.util.ArrayList;
import java.util.List;

// Main class
public class HospitalManagement {

    // Doctor class
    static class Doctor {
        private String name;
        private List<Patient> patients; // List of patients the doctor consults

        public Doctor(String name) {
            this.name = name;
            this.patients = new ArrayList<>();
        }

        // Add a patient to the doctor's list
        public void addPatient(Patient patient) {
            patients.add(patient);
        }

        // Show consultations with patients
        public void consult() {
            System.out.println("Doctor " + name + " is consulting with:");
            for (Patient p : patients) {
                System.out.println("- " + p.getName());
            }
            System.out.println();
        }

        public String getName() {
            return name;
        }
    }

    // Patient class
    static class Patient {
        private String name;
        private List<Doctor> doctors; // List of doctors the patient consults

        public Patient(String name) {
            this.name = name;
            this.doctors = new ArrayList<>();
        }

        // Add a doctor to the patient's list
        public void addDoctor(Doctor doctor) {
            doctors.add(doctor);
        }

        public String getName() {
            return name;
        }

        // Show all doctors the patient consults
        public void showDoctors() {
            System.out.println("Patient " + name + " consults:");
            for (Doctor d : doctors) {
                System.out.println("- " + d.getName());
            }
            System.out.println();
        }
    }

    // Hospital class
    static class Hospital {
        private List<Doctor> doctors;
        private List<Patient> patients;

        public Hospital() {
            doctors = new ArrayList<>();
            patients = new ArrayList<>();
        }

        public void addDoctor(Doctor doctor) {
            doctors.add(doctor);
        }

        public void addPatient(Patient patient) {
            patients.add(patient);
        }

        public List<Doctor> getDoctors() {
            return doctors;
        }

        public List<Patient> getPatients() {
            return patients;
        }
    }

    // Main method to demonstrate association
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        // Create doctors
        Doctor doc1 = new Doctor("Dr. Smith");
        Doctor doc2 = new Doctor("Dr. Alice");

        // Create patients
        Patient pat1 = new Patient("John");
        Patient pat2 = new Patient("Emma");

        // Add doctors and patients to hospital
        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);
        hospital.addPatient(pat1);
        hospital.addPatient(pat2);

        // Establish consultations (association)
        doc1.addPatient(pat1);
        doc1.addPatient(pat2);
        doc2.addPatient(pat1);

        pat1.addDoctor(doc1);
        pat1.addDoctor(doc2);
        pat2.addDoctor(doc1);

        // Show consultations
        doc1.consult();
        doc2.consult();

        // Show which doctors a patient consults
        pat1.showDoctors();
        pat2.showDoctors();
    }
}
