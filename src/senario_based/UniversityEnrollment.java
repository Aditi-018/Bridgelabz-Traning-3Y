package senario_based;

// File: UniversityEnrollment.java

// Interface
interface Graded {
    void assignGrade(Student student, String grade);
}

// Base Student Class
class Student {
    private String name;
    private int id;
    private double totalPoints;
    private int coursesCount;
    private String elective;

    // Constructor without elective
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Overloaded Constructor with elective
    public Student(String name, int id, String elective) {
        this.name = name;
        this.id = id;
        this.elective = elective;
    }

    // Encapsulation: secure GPA handling
    public void addGradePoints(double points) {
        totalPoints += points;
        coursesCount++;
    }

    public double getGPA() {
        return (coursesCount == 0) ? 0 : totalPoints / coursesCount;
    }

    public String getTranscript() {
        return "Transcript of " + name + " (ID: " + id + "): GPA = " + getGPA();
    }

    public String getName() { return name; }
}

// Inheritance: Undergraduate Student
class Undergraduate extends Student {
    public Undergraduate(String name, int id) {
        super(name, id);
    }
}

// Inheritance: Postgraduate Student
class Postgraduate extends Student {
    public Postgraduate(String name, int id, String elective) {
        super(name, id, elective);
    }
}

// Course Class
class Course {
    private String courseName;
    private int courseId;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseName() { return courseName; }
}

// Faculty Class
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Faculty: " + name);
    }
}

// Enrollment Class
class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void showEnrollment() {
        System.out.println(student.getName() + " enrolled in " + course.getCourseName());
    }
}

// Grading Style 1: Letter Grading
class LetterGrading implements Graded {
    @Override
    public void assignGrade(Student student, String grade) {
        double points = 0;
        switch (grade) {
            case "A": points = 4.0; break;
            case "B": points = 3.0; break;
            case "C": points = 2.0; break;
            case "D": points = 1.0; break;
            default: points = 0.0; break;
        }
        student.addGradePoints(points);
    }
}

// Grading Style 2: Pass/Fail
class PassFailGrading implements Graded {
    @Override
    public void assignGrade(Student student, String grade) {
        if (grade.equalsIgnoreCase("Pass")) {
            student.addGradePoints(3.0); // Give fixed points for pass
        } else {
            student.addGradePoints(0.0);
        }
    }
}

// Main Class
public class UniversityEnrollment {
    public static void main(String[] args) {
        Student s1 = new Undergraduate("Aditi", 101);
        Student s2 = new Postgraduate("Rahul", 102, "AI");

        Course c1 = new Course(1, "Data Structures");
        Course c2 = new Course(2, "Machine Learning");

        Faculty f1 = new Faculty("Dr. Sharma");
        f1.displayInfo();

        Enrollment e1 = new Enrollment(s1, c1);
        Enrollment e2 = new Enrollment(s2, c2);

        System.out.println("\n---- Enrollments ----");
        e1.showEnrollment();
        e2.showEnrollment();

        // Grading
        Graded letter = new LetterGrading();
        Graded passFail = new PassFailGrading();

        letter.assignGrade(s1, "A");
        passFail.assignGrade(s2, "Pass");

        System.out.println("\n---- Transcripts ----");
        System.out.println(s1.getTranscript());
        System.out.println(s2.getTranscript());
    }
}
