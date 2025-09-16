package keywords;

// File name: UniversitySystemDemo.java

class Student {
    // Static variable shared across all students
    static String universityName = "ABC University";
    private static int totalStudents = 0;

    // Final variable (cannot be changed once assigned)
    private final int rollNumber;

    // Instance variables
    private String name;
    private String grade;

    // Constructor using 'this' keyword
    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber; // final variable initialized here
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    // Instance method to display student details (with instanceof check)
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University (static): " + universityName);
            System.out.println("Roll Number (final): " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Not a valid Student object.");
        }
    }

    // Method to update grade
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + grade);
        } else {
            System.out.println("Invalid operation. Not a Student object.");
        }
    }

    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
}

// Main class
public class UniversitySystemDemo {
    public static void main(String[] args) {
        // Create student objects
        Student s1 = new Student(101, "Aditi Sahu", "A");
        Student s2 = new Student(102, "Rahul Sharma", "B");

        // Display student details
        s1.displayStudentDetails();
        System.out.println();
        s2.displayStudentDetails();

        System.out.println();
        // Update grade
        s2.updateGrade("A");

        System.out.println();
        // Display total students
        Student.displayTotalStudents();

        System.out.println();
        // instanceof demonstration
        if (s1 instanceof Student) {
            System.out.println("s1 is a valid Student instance.");
        }
    }
}

