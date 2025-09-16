package programing_practices;

// File name: EmployeeSystemDemo.java

class Employee {
    // Static variable (shared by all employees)
    static String companyName = "Tech Solutions Pvt. Ltd.";
    private static int totalEmployees = 0;

    // Final variable (cannot be modified once assigned)
    private final int id;

    // Instance variables
    private String name;
    private String designation;

    // Constructor using 'this' keyword
    public Employee(int id, String name, String designation) {
        this.id = id;                // 'this' resolves ambiguity
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    // Instance method to display employee details (with instanceof check)
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company (static): " + companyName);
            System.out.println("Employee ID (final): " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Not a valid Employee object.");
        }
    }

    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
}

// Main class
public class EmployeeSystemDemo {
    public static void main(String[] args) {
        // Creating employee objects
        Employee e1 = new Employee(101, "Aditi Sahu", "Software Engineer");
        Employee e2 = new Employee(102, "Rahul Sharma", "Manager");

        // Displaying details
        e1.displayEmployeeDetails();
        System.out.println();
        e2.displayEmployeeDetails();

        System.out.println();
        // Display total employees (static method)
        Employee.displayTotalEmployees();

        System.out.println();
        // instanceof demonstration
        if (e1 instanceof Employee) {
            System.out.println("e1 is a valid Employee instance.");
        }
    }
}
