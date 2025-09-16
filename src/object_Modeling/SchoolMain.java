package object_Modeling;

import java.util.ArrayList;

// Course class
class Course {
    private String courseName;
    private ArrayList<Student> students; // association

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    // Add student to course (association)
    public void addStudent(Student student) {
        students.add(student);
    }

    // Display all students in this course
    public void displayStudents() {
        System.out.println("Course: " + courseName + " has the following students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
        System.out.println();
    }

    public String getCourseName() {
        return courseName;
    }
}

// Student class
class Student {
    private String name;
    private int id;
    private ArrayList<Course> courses; // association

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    // Enroll student in a course
    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this); // update course's student list
    }

    // View all courses the student is enrolled in
    public void viewCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

// School class (Aggregation)
class School {
    private String schoolName;
    private ArrayList<Student> students; // aggregation

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Add student to school
    public void addStudent(Student student) {
        students.add(student);
    }

    // Display all students in school
    public void displayStudents() {
        System.out.println("School: " + schoolName + " has the following students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
        System.out.println();
    }
}

// Main class
public class SchoolMain {
    public static void main(String[] args) {
        // Create courses
        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");
        Course english = new Course("English");

        // Create students
        Student student1 = new Student("Alice", 101);
        Student student2 = new Student("Bob", 102);
        Student student3 = new Student("Charlie", 103);

        // Enroll students in courses (association)
        student1.enrollCourse(math);
        student1.enrollCourse(english);

        student2.enrollCourse(physics);
        student2.enrollCourse(math);

        student3.enrollCourse(english);

        // Create school and add students (aggregation)
        School school = new School("Greenwood High");
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        // Display school info
        school.displayStudents();

        // Display courses of each student
        student1.viewCourses();
        student2.viewCourses();
        student3.viewCourses();

        // Display students in each course
        math.displayStudents();
        physics.displayStudents();
        english.displayStudents();
    }
}
