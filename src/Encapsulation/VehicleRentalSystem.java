package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Interface for insurable vehicles
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate; // per day

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);

    // Encapsulation: getters and setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Display vehicle details
    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Cost for " + days + " days: $" + calculateRentalCost(days));
        if (this instanceof Insurable) {
            Insurable ins = (Insurable) this;
            System.out.println("Insurance: $" + ins.calculateInsurance() + " (" + ins.getInsuranceDetails() + ")");
        }
        System.out.println();
    }
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Car rental = base rate * days + 10% extra for service
        return getRentalRate() * days * 1.1;
    }

    @Override
    public double calculateInsurance() {
        // 5% of base rentalRate as insurance
        return getRentalRate() * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy No: " + insurancePolicyNumber;
    }

    // Getter/Setter for insurancePolicyNumber
    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        // Bike rental = base rate * days
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        // 3% of base rentalRate as insurance
        return getRentalRate() * 0.03;
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy No: " + insurancePolicyNumber;
    }
}

// Truck class
class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Truck rental = base rate * days + 20% for heavy vehicle
        return getRentalRate() * days * 1.2;
    }
}

// Main class to demonstrate polymorphism
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR123", 50, "INS1001"));
        vehicles.add(new Bike("BIKE456", 20, "INS2002"));
        vehicles.add(new Truck("TRUCK789", 100));

        int rentalDays = 5;

        // Polymorphism: iterate over all vehicles
        for (Vehicle v : vehicles) {
            v.displayDetails(rentalDays);
        }
    }
}
