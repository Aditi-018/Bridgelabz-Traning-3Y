package inheritance;

// Save this file as SmartHomeSystem.java

// Superclass: Device
class Device {
    String deviceId;
    String status;  // e.g., "ON" or "OFF"

    // Constructor
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display status
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass: Thermostat
class Thermostat extends Device {
    double temperatureSetting;

    // Constructor
    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status); // Call superclass constructor
        this.temperatureSetting = temperatureSetting;
    }

    // Overriding method to display thermostat-specific info
    @Override
    public void displayStatus() {
        super.displayStatus(); // Show deviceId and status
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        System.out.println("--------------------------------");
    }
}

// Main class
public class SmartHomeSystem {
    public static void main(String[] args) {
        // Create a thermostat device
        Thermostat thermostat1 = new Thermostat("T1001", "ON", 24.5);
        Thermostat thermostat2 = new Thermostat("T1002", "OFF", 20.0);

        // Display status of devices
        thermostat1.displayStatus();
        thermostat2.displayStatus();
    }
}

