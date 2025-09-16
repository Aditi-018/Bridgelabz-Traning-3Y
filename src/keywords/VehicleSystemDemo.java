package keywords;

// File name: VehicleSystemDemo.java

class Vehicle {
    // Static variable common for all vehicles
    static double registrationFee = 5000.0;

    // Final variable for unique registration number
    private final String registrationNumber;

    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Constructor using 'this'
    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;  // final, so set only once
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details (with instanceof check)
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number (final): " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee (static): " + registrationFee);
        } else {
            System.out.println("Not a valid Vehicle object.");
        }
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        if (newFee > 0) {
            registrationFee = newFee;
            System.out.println("Registration fee updated to: " + registrationFee);
        } else {
            System.out.println("Invalid registration fee.");
        }
    }
}

// Main class
public class VehicleSystemDemo {
    public static void main(String[] args) {
        // Create vehicle objects
        Vehicle v1 = new Vehicle("MH01AB1234", "Aditi Sahu", "Car");
        Vehicle v2 = new Vehicle("DL05XY6789", "Rahul Sharma", "Bike");

        // Display details before fee update
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        System.out.println("\n--- Updating Registration Fee ---");
        // Update registration fee (static method)
        Vehicle.updateRegistrationFee(6000.0);

        System.out.println();
        // Display details after fee update
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        System.out.println();
        // instanceof demonstration
        if (v1 instanceof Vehicle) {
            System.out.println("v1 is a valid Vehicle instance.");
        }
    }
}

