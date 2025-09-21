package senario_based;

// File name: CabbyGoApp.java

// Interface for ride services
interface IRideService {
    void bookRide(double distance);
    void endRide();
}

// Base Vehicle class
abstract class Vehicle {
    private String vehicleNumber;
    private int capacity;
    private String type;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    // Abstract fare calculation method
    public abstract double calculateFare(double distance);
}

// Mini vehicle
class Mini extends Vehicle {
    private static final double BASE_FARE = 50;
    private static final double RATE = 10;

    public Mini(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Mini");
    }

    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (distance * RATE);
    }
}

// Sedan vehicle
class Sedan extends Vehicle {
    private static final double BASE_FARE = 80;
    private static final double RATE = 15;

    public Sedan(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Sedan");
    }

    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (distance * RATE);
    }
}

// SUV vehicle
class SUV extends Vehicle {
    private static final double BASE_FARE = 120;
    private static final double RATE = 20;

    public SUV(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "SUV");
    }

    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (distance * RATE);
    }
}

// Driver class
class Driver {
    private String name;
    private String licenseNumber;
    private double rating; // private for encapsulation

    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double getRating() {
        return rating;
    }
}

// RideService implementation
class RideService implements IRideService {
    private Vehicle vehicle;
    private Driver driver;
    private boolean isOngoing;
    private double fare; // encapsulated
    private double distance;

    public RideService(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
        this.isOngoing = false;
    }

    @Override
    public void bookRide(double distance) {
        if (isOngoing) {
            System.out.println("❌ Ride is already in progress.");
            return;
        }
        this.distance = distance;
        this.fare = vehicle.calculateFare(distance);
        isOngoing = true;
        System.out.println("✅ Ride booked with " + driver.getName() + " in " + vehicle.getType() +
                " [" + vehicle.getVehicleNumber() + "]. Estimated Fare: ₹" + fare);
    }

    @Override
    public void endRide() {
        if (!isOngoing) {
            System.out.println("❌ No ongoing ride to end.");
            return;
        }
        System.out.println("🏁 Ride ended. Distance: " + distance + " km. Final Fare: ₹" + fare);
        isOngoing = false;
    }

    public double getFare() {
        return fare;
    }
}

// Main App
public class CabbyGoApp {
    public static void main(String[] args) {
        // Create vehicles
        Vehicle mini = new Mini("MH12AB1234", 4);
        Vehicle sedan = new Sedan("MH12CD5678", 4);
        Vehicle suv = new SUV("MH12EF9012", 6);

        // Create drivers
        Driver d1 = new Driver("Aditi", "DL12345", 4.9);
        Driver d2 = new Driver("Rahul", "DL67890", 4.7);

        // Book rides
        RideService ride1 = new RideService(mini, d1);
        ride1.bookRide(12);
        ride1.endRide();

        RideService ride2 = new RideService(suv, d2);
        ride2.bookRide(25);
        ride2.endRide();
    }
}
