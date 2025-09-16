package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// GPS Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Vehicle class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Abstract method to calculate fare
    public abstract double calculateFare(double distance);

    // Concrete method to display vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    // Encapsulation: getters and setters
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
}

// Car class
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 5; // extra $5 for car service fee
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        super.setCurrentLocation(newLocation);
    }
}

// Bike class
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance; // simple fare
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        super.setCurrentLocation(newLocation);
    }
}

// Auto class
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 2; // extra $2 service charge
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        super.setCurrentLocation(newLocation);
    }
}

// Main class to demonstrate polymorphism
public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        Car car = new Car("CAR001", "Alice", 10, "Downtown");
        Bike bike = new Bike("BIKE002", "Bob", 5, "Uptown");
        Auto auto = new Auto("AUTO003", "Charlie", 7, "Central Park");

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(auto);

        double distance = 15; // example ride distance in km

        System.out.println("--- Ride Fare Details ---");
        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: $" + v.calculateFare(distance));
            System.out.println();
        }

        // Demonstrate GPS update
        System.out.println("--- Updating Vehicle Locations ---");
        for (Vehicle v : vehicles) {
            if (v instanceof GPS) {
                ((GPS)v).updateLocation("New Location");
                System.out.println(v.getDriverName() + " updated location: " + ((GPS)v).getCurrentLocation());
            }
        }
    }
}
