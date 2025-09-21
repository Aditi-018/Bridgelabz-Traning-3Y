package senario_based;

// File name: CampusConnectApp.java

import java.util.ArrayList;
import java.util.List;

// Interface for course actions
interface ICourseActions {
    void enrollCourse(Course course);
    void dropCourse(Course course);
}

// Base Person class
abstract class Person {
    private String name;
    private String email;
    private int id;

    public Person(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getId() { return id; }

    public abstract void printDetails();
}

// Student class
class Student extends Person implements ICourseActions {
    private List<Course> enrolledCourses;
    private List<Double> grades; // encapsulated

    public Student(String name, String email, int id) {
        super(name, email, id);
        enrolledCourses = new ArrayList<>();
        grades = new ArrayList<>();
    }

    @Override
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
        grades.add(0.0); // initialize grade
        System.out.println(getName() + " enrolled in " + course.getCourseName());
    }

    @Override
    public void dropCourse(Course course) {
        int index = enrolledCourses.indexOf(course);
        if (index != -1) {
            enrolledCourses.remove(index);
            grades.remove(index);
            course.removeStudent(this);
            System.out.println(getName() + " dropped " + course.getCourseName());
        }
    }

    public void setGrade(Course course, double grade) {
        int index = enrolledCourses.indexOf(course);
        if (index != -1) {
            grades.set(index, grade);
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0;
        double total = 0;
        for (double g : grades) {
            total += g; // using operator +
        }
        return total / grades.size(); // using operator /
    }

    @Override
    public void printDetails() {
        System.out.println("Student: " + getName() + ", Email: " + getEmail() + ", GPA: " + calculateGPA());
    }
}

// Faculty class
class Faculty extends Person {
    private List<Course> assignedCourses;

    public Faculty(String name, String email, int id) {
        super(name, email, id);
        assignedCourses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        assignedCourses.add(course);
        course.setFaculty(this);
        System.out.println(getName() + " assigned to " + course.getCourseName());
    }

    @Override
    public void printDetails() {
        System.out.print("Faculty: " + getName() + ", Courses: ");
        for (Course c : assignedCourses) {
            System.out.print(c.getCourseName() + " ");
        }
        System.out.println();
    }
}

// Course class
class Course {
    private String courseName;
    private Faculty faculty;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }

    public String getCourseName() { return courseName; }

    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    public void addStudent(Student student) {
        if (!students.contains(student)) students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void printCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.print("Faculty: ");
        if (faculty != null) System.out.println(faculty.getName());
        else System.out.println("None");

        System.out.print("Students: ");
        for (Student s : students) {
            System.out.print(s.getName() + " ");
        }
        System.out.println("\n");
    }
}

// Main Application
public class CampusConnectApp {
    public static void main(String[] args) {
        // Create faculty
        Faculty f1 = new Faculty("Dr. Sharma", "sharma@uni.edu", 101);
        Faculty f2 = new Faculty("Prof. Mehta", "mehta@uni.edu", 102);

        // Create students
        Student s1 = new Student("Aditi", "aditi@uni.edu", 201);
        Student s2 = new Student("Rahul", "rahul@uni.edu", 202);

        // Create courses
        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Machine Learning");

        // Assign faculty
        f1.assignCourse(c1);
        f2.assignCourse(c2);

        // Enroll students
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        // Set grades
        s1.setGrade(c1, 9.0);
        s1.setGrade(c2, 8.5);
        s2.setGrade(c1, 7.5);

        // Print details
        System.out.println("\n---- Details ----");
        s1.printDetails();
        s2.printDetails();
        f1.printDetails();
        f2.printDetails();

        // Print course details
        System.out.println("\n---- Courses ----");
        c1.printCourseDetails();
        c2.printCourseDetails();
    }
}
