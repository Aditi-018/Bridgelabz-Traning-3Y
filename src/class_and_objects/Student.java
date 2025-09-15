package class_and_objects;

// File name: Student.java

public class Student {
    String name;
    String rollNumber;
    double[] marks;

    // Constructor
    Student(String name, String rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade
    public String calculateGrade() {
        double averageMarks = calculateAverageMarks();

        if (averageMarks >= 80 && averageMarks <= 100) {
            return "Grade A";
        } else if (averageMarks >= 60) {
            return "Grade B";
        } else if (averageMarks >= 50) {
            return "Grade C";
        } else if (averageMarks >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Roll Number: " + rollNumber);
        System.out.println("Student Marks:");

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Mark " + (i + 1) + ": " + marks[i]);
        }

        System.out.println(calculateGrade());
        System.out.println("----------------------------------");
    }

    // Method to calculate average marks
    public double calculateAverageMarks() {
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        return sum / marks.length;
    }

    // Main method
    public static void main(String[] args) {
        double[] mark1 = {80, 70, 75};
        double[] mark2 = {60, 65, 50};

        Student student1 = new Student("Thamarai", "ECE001", mark1);
        Student student2 = new Student("Kannan", "CSC002", mark2);

        student1.displayStudentDetails();
        student2.displayStudentDetails();
    }
}
