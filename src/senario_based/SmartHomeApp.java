package senario_based;

// File name: SmartHomeApp.java

// Common interface for all appliances
interface Controllable {
    void turnOn();
    void turnOff();
}

// Base class for appliances
abstract class Appliance implements Controllable {
    private String name;
    private boolean isOn;
    private int powerUsage; // in watts

    // Constructor: default or user-defined power
    public Appliance(String name, int powerUsage) {
        this.name = name;
        this.powerUsage = powerUsage;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public int getPowerUsage() {
        return powerUsage;
    }

    public boolean isOn() {
        return isOn;
    }

    protected void setOn(boolean on) {
        this.isOn = on;
    }

    // Encapsulation: toggle methods as public
    public void toggle() {
        if (isOn) {
            turnOff();
        } else {
            turnOn();
        }
    }

    // Compare energy usage with another appliance (operators)
    public void compareUsage(Appliance other) {
        if (this.powerUsage > other.powerUsage) {
            System.out.println(this.name + " uses more power than " + other.name);
        } else if (this.powerUsage < other.powerUsage) {
            System.out.println(this.name + " uses less power than " + other.name);
        } else {
            System.out.println(this.name + " and " + other.name + " use the same power.");
        }
    }
}

// Light class
class Light extends Appliance {
    public Light(int powerUsage) {
        super("Light", powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println("💡 Light is turned ON.");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("💡 Light is turned OFF.");
    }
}

// Fan class
class Fan extends Appliance {
    public Fan(int powerUsage) {
        super("Fan", powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println("🌀 Fan is spinning.");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("🌀 Fan is stopped.");
    }
}

// AC class
class AC extends Appliance {
    public AC(int powerUsage) {
        super("Air Conditioner", powerUsage);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println("❄️ AC is cooling the room.");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("❄️ AC is turned OFF.");
    }
}

// User Controller
class UserController {
    public void controlAppliance(Appliance appliance, boolean turnOn) {
        if (turnOn) {
            appliance.turnOn();
        } else {
            appliance.turnOff();
        }
    }
}

// Main Application
public class SmartHomeApp {
    public static void main(String[] args) {
        // Create appliances
        Light light = new Light(60);  // default 60W
        Fan fan = new Fan(75);        // default 75W
        AC ac = new AC(1500);         // default 1500W

        // User controller
        UserController controller = new UserController();

        // Control appliances
        controller.controlAppliance(light, true);
        controller.controlAppliance(fan, true);
        controller.controlAppliance(ac, true);

        // Turn off light
        controller.controlAppliance(light, false);

        // Compare usage
        light.compareUsage(fan);
        ac.compareUsage(fan);
    }
}
