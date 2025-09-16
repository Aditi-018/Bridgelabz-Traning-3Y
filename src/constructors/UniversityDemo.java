package constructors;

// Base class
class Student {
    public int rollNumber;       // public
    protected String name;       // protected
    private double CGPA;         // private

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Getter for CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Setter for CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA. Must be between 0.0 and 10.0");
        }
    }

    public void displayStudentDetails() {
        System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", CGPA: " + CGPA);
    }
}

// Subclass demonstrating use of protected member
class PostgraduateStudent extends Student {
    private String specialization;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    public void displayPostgraduateDetails() {
        // Accessing protected variable 'name' directly
        System.out.println("PG Student Name: " + name +
                ", Roll No: " + rollNumber +
                ", CGPA: " + getCGPA() +
                ", Specialization: " + specialization);
    }
}

// Demo Class
public class UniversityDemo {
    public static void main(String[] args) {
        // Create a Student
        Student s1 = new Student(101, "Aditi Sahu", 8.5);
        s1.displayStudentDetails();

        // Update CGPA
        s1.setCGPA(9.0);
        System.out.println("Updated CGPA: " + s1.getCGPA());

        // Create a PostgraduateStudent
        PostgraduateStudent pg1 = new PostgraduateStudent(201, "Ravi Kumar", 9.2, "Computer Science");
        pg1.displayPostgraduateDetails();
    }
}

