package inheritance;


class Person {
    String name;
    int id;

    // Constructor
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display basic details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Worker Interface
interface Worker {
    void performDuties(); // abstract method
}

// Subclass Chef
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        displayDetails();
        System.out.println("Role: Chef");
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Cooking delicious meals.");
        System.out.println("---------------------------");
    }
}

// Subclass Waiter
class Waiter extends Person implements Worker {
    int tablesAssigned;

    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        displayDetails();
        System.out.println("Role: Waiter");
        System.out.println("Tables Assigned: " + tablesAssigned);
        System.out.println("Duties: Serving food to customers.");
        System.out.println("---------------------------");
    }
}

// Main class
public class RestaurantDemo {
    public static void main(String[] args) {
        Worker chef = new Chef("Ramesh", 101, "Indian Cuisine");
        Worker waiter = new Waiter("Aditi", 201, 5);

        // Polymorphism in action
        chef.performDuties();
        waiter.performDuties();
    }
}
