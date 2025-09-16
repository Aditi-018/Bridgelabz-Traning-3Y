package object_Modeling;

import java.util.ArrayList;

// Faculty class (aggregation - can exist independently)
class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("Faculty Name: " + name + ", Specialization: " + specialization);
    }

    public String getName() {
        return name;
    }
}

// Department class (composition - cannot exist without University)
class Department {
    private String deptName;
    private ArrayList<Faculty> faculties;

    public Department(String deptName) {
        this.deptName = deptName;
        this.faculties = new ArrayList<>();
    }

    // Add faculty to department (optional)
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void displayDepartmentInfo() {
        System.out.println("Department: " + deptName);
        if (faculties.isEmpty()) {
            System.out.println("No faculty assigned.");
        } else {
            for (Faculty f : faculties) {
                f.displayInfo();
            }
        }
        System.out.println();
    }
}

// University class (composition with Departments)
class University {
    private String universityName;
    private ArrayList<Department> departments;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }

    // Add department to university (composition)
    public Department addDepartment(String deptName) {
        Department dept = new Department(deptName);
        departments.add(dept);
        return dept;
    }

    // Display university info
    public void displayUniversityInfo() {
        System.out.println("University: " + universityName);
        for (Department d : departments) {
            d.displayDepartmentInfo();
        }
    }

    // Delete university (simulate deletion of all departments)
    public void deleteUniversity() {
        departments.clear();
        System.out.println("University " + universityName + " and all its departments are deleted.\n");
    }
}

// Main class
public class UniversityMain {
    public static void main(String[] args) {
        // Create faculty members (aggregation - independent)
        Faculty faculty1 = new Faculty("Dr. Smith", "Computer Science");
        Faculty faculty2 = new Faculty("Dr. Johnson", "Mathematics");
        Faculty faculty3 = new Faculty("Dr. Williams", "Physics");

        // Faculties exist independently
        System.out.println("Independent Faculty Members:");
        faculty1.displayInfo();
        faculty2.displayInfo();
        faculty3.displayInfo();
        System.out.println();

        // Create University
        University uni = new University("Global University");

        // Add departments (composition)
        Department csDept = uni.addDepartment("Computer Science");
        Department mathDept = uni.addDepartment("Mathematics");

        // Assign faculties to departments (optional)
        csDept.addFaculty(faculty1);  // faculty1 is in CS
        mathDept.addFaculty(faculty2); // faculty2 is in Math

        // Display university info
        uni.displayUniversityInfo();

        // Delete university (composition effect)
        uni.deleteUniversity();

        // Try displaying after deletion
        uni.displayUniversityInfo(); // should show nothing

        // Faculties still exist independently
        System.out.println("Independent Faculty Members after University deletion:");
        faculty1.displayInfo();
        faculty2.displayInfo();
        faculty3.displayInfo();
    }
}
