package object_Modeling;

import java.util.ArrayList;

// Employee class
class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + id + ", Name: " + name);
    }
}

// Department class
class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    // Add employee to department
    public void addEmployee(String name, int id) {
        employees.add(new Employee(name, id));
    }

    // Display department and employee info
    public void displayDepartmentInfo() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            e.displayInfo();
        }
        System.out.println();
    }
}

// Company class
class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    // Add department to company
    public Department addDepartment(String deptName) {
        Department dept = new Department(deptName);
        departments.add(dept);
        return dept;
    }

    // Display all departments and employees
    public void displayCompanyInfo() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.displayDepartmentInfo();
        }
    }

    // Delete company (simulate deletion of all departments and employees)
    public void deleteCompany() {
        departments.clear();
        System.out.println("Company " + companyName + " and all its departments and employees are deleted.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create company
        Company company = new Company("Tech Solutions");

        // Add departments and employees
        Department devDept = company.addDepartment("Development");
        devDept.addEmployee("Alice", 101);
        devDept.addEmployee("Bob", 102);

        Department hrDept = company.addDepartment("HR");
        hrDept.addEmployee("Charlie", 201);

        // Display company info
        company.displayCompanyInfo();

        // Delete company
        company.deleteCompany();

        // Try displaying after deletion
        company.displayCompanyInfo(); // should show nothing
    }
}
