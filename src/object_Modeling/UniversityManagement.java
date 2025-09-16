package object_Modeling;

import java.util.ArrayList;
import java.util.List;

// Main class
public class UniversityManagement {

    // Course class
    static class Course {
        private String courseName;
        private Professor professor; // Course is taught by a professor
        private List<Student> enrolledStudents; // Students enrolled in the course

        public Course(String courseName) {
            this.courseName = courseName;
            this.enrolledStudents = new ArrayList<>();
        }

        // Assign a professor to the course
        public void assignProfessor(Professor professor) {
            this.professor = professor;
            professor.addCourse(this); // Professor now teaches this course
        }

        // Enroll a student in the course
        public void enrollStudent(Student student) {
            enrolledStudents.add(student);
            student.addCourse(this); // Student now has this course
        }

        public String getCourseName() {
            return courseName;
        }

        public Professor getProfessor() {
            return professor;
        }

        public List<Student> getEnrolledStudents() {
            return enrolledStudents;
        }

        public void showCourseDetails() {
            System.out.println("Course: " + courseName);
            System.out.println("Professor: " + (professor != null ? professor.getName() : "None"));
            System.out.println("Enrolled Students:");
            for (Student s : enrolledStudents) {
                System.out.println("- " + s.getName());
            }
            System.out.println();
        }
    }

    // Professor class
    static class Professor {
        private String name;
        private List<Course> coursesTeaching; // Courses the professor teaches

        public Professor(String name) {
            this.name = name;
            this.coursesTeaching = new ArrayList<>();
        }

        public void addCourse(Course course) {
            coursesTeaching.add(course);
        }

        public String getName() {
            return name;
        }

        public void showCourses() {
            System.out.println("Professor " + name + " teaches:");
            for (Course c : coursesTeaching) {
                System.out.println("- " + c.getCourseName());
            }
            System.out.println();
        }
    }

    // Student class
    static class Student {
        private String name;
        private List<Course> coursesEnrolled; // Courses the student enrolled in

        public Student(String name) {
            this.name = name;
            this.coursesEnrolled = new ArrayList<>();
        }

        public void addCourse(Course course) {
            coursesEnrolled.add(course);
        }

        public String getName() {
            return name;
        }

        public void showCourses() {
            System.out.println("Student " + name + " is enrolled in:");
            for (Course c : coursesEnrolled) {
                System.out.println("- " + c.getCourseName() + " (Professor: " + c.getProfessor().getName() + ")");
            }
            System.out.println();
        }
    }

    // Main method to demonstrate interaction
    public static void main(String[] args) {
        // Create professors
        Professor prof1 = new Professor("Dr. Smith");
        Professor prof2 = new Professor("Dr. Alice");

        // Create students
        Student student1 = new Student("John");
        Student student2 = new Student("Emma");

        // Create courses
        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Operating Systems");

        // Assign professors to courses
        course1.assignProfessor(prof1);
        course2.assignProfessor(prof2);

        // Enroll students in courses
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course2.enrollStudent(student1);

        // Display details
        course1.showCourseDetails();
        course2.showCourseDetails();

        prof1.showCourses();
        prof2.showCourses();

        student1.showCourses();
        student2.showCourses();
    }
}
