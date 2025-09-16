package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Abstract Employee class
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Concrete method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Calculated Salary: $" + calculateSalary());
    }

    // Getters and Setters (Encapsulation)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        // For simplicity, full-time employees get baseSalary + 20% bonus
        return getBaseSalary() * 1.2;
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee {
    private int workHours;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
    }

    @Override
    public double calculateSalary() {
        // Part-time salary based on hours worked (hourly rate = baseSalary / 160)
        double hourlyRate = getBaseSalary() / 160;
        return hourlyRate * workHours;
    }

    // Getter and Setter for workHours
    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
}

// Department interface
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// HRDepartment implementing Department interface
class HRDepartment implements Department {
    private String departmentName;

    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + departmentName;
    }
}

// Main class to demonstrate polymorphism
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create employees
        Employee emp1 = new FullTimeEmployee(101, "Alice", 5000);
        Employee emp2 = new PartTimeEmployee(102, "Bob", 3000, 80);

        // Assign department
        HRDepartment hr = new HRDepartment();
        hr.assignDepartment("Human Resources");
        System.out.println(hr.getDepartmentDetails());
        System.out.println();

        // Store employees in a list (Polymorphism)
        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);

        // Display details of all employees
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
}

