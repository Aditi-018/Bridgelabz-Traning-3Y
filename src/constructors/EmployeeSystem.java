package constructors;

// File name: EmployeeSystem.java

// Base class: Employee
class Employee {
    // Access modifiers
    public int employeeID;
    protected String department;
    private double salary;

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to set salary
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
            System.out.println("Salary updated to: " + salary);
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }
}

// Subclass: Manager
class Manager extends Employee {
    private String role;

    // Constructor
    public Manager(int employeeID, String department, double salary, String role) {
        super(employeeID, department, salary);
        this.role = role;
    }

    // Method to display Manager details (demonstrating public & protected access)
    public void displayManagerDetails() {
        System.out.println("Employee ID (public): " + employeeID);
        System.out.println("Department (protected): " + department);
        System.out.println("Role: " + role);
    }
}

// Main class
public class EmployeeSystem {
    public static void main(String[] args) {
        // Create Employee object
        Employee emp1 = new Employee(101, "Finance", 45000);
        System.out.println("Initial Salary: " + emp1.getSalary());
        emp1.setSalary(50000);
        System.out.println("Updated Salary: " + emp1.getSalary());

        System.out.println();

        // Create Manager object
        Manager mgr = new Manager(201, "IT", 80000, "Team Lead");
        mgr.setSalary(90000); // modifying salary
        System.out.println("Manager Salary: " + mgr.getSalary());
        mgr.displayManagerDetails();
    }
}
