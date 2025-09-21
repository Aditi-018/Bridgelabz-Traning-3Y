package senario_based;
// File: VehicleRental.java

// Interface
interface Rentable {
    double calculateRent(int days);
}

// Parent Class
class Vehicle implements Rentable {
    protected String vehicleNo;
    protected String brand;
    protected double baseRate;

    public Vehicle(String vehicleNo, String brand, double baseRate) {
        this.vehicleNo = vehicleNo;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    // Encapsulation - getters
    public String getVehicleNo() { return vehicleNo; }
    public String getBrand() { return brand; }
    public double getBaseRate() { return baseRate; }

    // Default implementation (overridden in subclasses)
    @Override
    public double calculateRent(int days) {
        return baseRate * days;
    }

    public void displayInfo() {
        System.out.println("Vehicle No: " + vehicleNo + ", Brand: " + brand);
    }
}

// Bike Class
class Bike extends Vehicle {
    public Bike(String vehicleNo, String brand, double baseRate) {
        super(vehicleNo, brand, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        // No extra surcharge for bikes
        return baseRate * days;
    }
}

// Car Class
class Car extends Vehicle {
    private double luxurySurcharge = 500; // Extra charge

    public Car(String vehicleNo, String brand, double baseRate) {
        super(vehicleNo, brand, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        return (baseRate * days) + luxurySurcharge;
    }
}

// Truck Class
class Truck extends Vehicle {
    private double loadCharge = 1000; // Extra charge for heavy load

    public Truck(String vehicleNo, String brand, double baseRate) {
        super(vehicleNo, brand, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        return (baseRate * days) + loadCharge;
    }
}

// Customer Class
class Customer {
    private String name;
    private String contact;

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public void displayInfo() {
        System.out.println("Customer: " + name + ", Contact: " + contact);
    }
}

// Main Class
public class VehicleRental {
    public static void main(String[] args) {
        Customer c1 = new Customer("Aditi", "9876543210");

        Vehicle v1 = new Bike("B101", "Honda", 300);
        Vehicle v2 = new Car("C202", "BMW", 1500);
        Vehicle v3 = new Truck("T303", "Tata", 2000);

        System.out.println("---- Customer Info ----");
        c1.displayInfo();

        System.out.println("\n---- Vehicle Rents ----");
        v1.displayInfo();
        System.out.println("Rent for 3 days: " + v1.calculateRent(3));

        v2.displayInfo();
        System.out.println("Rent for 3 days: " + v2.calculateRent(3));

        v3.displayInfo();
        System.out.println("Rent for 3 days: " + v3.calculateRent(3));
    }
}

