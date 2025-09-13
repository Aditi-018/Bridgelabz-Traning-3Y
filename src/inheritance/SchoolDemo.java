package inheritance;

// Superclass Person
class Person {
    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display common details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass Teacher
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        displayDetails();
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
        System.out.println("---------------------");
    }
}

// Subclass Student
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        displayDetails();
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
        System.out.println("---------------------");
    }
}

// Subclass Staff
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        displayDetails();
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
        System.out.println("---------------------");
    }
}

// Main class
public class SchoolDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Ramesh", 40, "Mathematics");
        Student student = new Student("Aditi", 20, "B.Tech 3rd Year");
        Staff staff = new Staff("Suman", 35, "Administration");

        // Displaying roles
        teacher.displayRole();
        student.displayRole();
        staff.displayRole();
    }
}
