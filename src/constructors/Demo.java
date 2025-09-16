package constructors;


// 1. Book Class
class Book {
    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price);
    }
}

// 2. Circle Class (Constructor Chaining)
class Circle {
    private double radius;

    public Circle() {
        this(1.0); // calls parameterized constructor
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void display() {
        System.out.println("Circle radius: " + radius);
    }
}

// 3. Person Class (Copy Constructor)
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// 4. Hotel Booking System
class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    public HotelBooking() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void display() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }
}

// 5. Library Book System
class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is not available.");
        }
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author +
                ", Price: " + price + ", Available: " + available);
    }
}

// 6. Car Rental System
class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double costPerDay = 1000.0;

    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateCost() {
        return rentalDays * costPerDay;
    }

    public void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel +
                ", Days: " + rentalDays + ", Total Cost: " + calculateCost());
    }
}

// ======================= Demo Class =======================
public class Demo {
    public static void main(String[] args) {

        // ---------- Book ----------
        System.out.println("=== Book Class Demo ===");
        Book b1 = new Book();
        Book b2 = new Book("Harry Potter", "J.K. Rowling", 450.0);
        b1.display();
        b2.display();

        // ---------- Circle ----------
        System.out.println("\n=== Circle Class Demo ===");
        Circle c1 = new Circle();
        Circle c2 = new Circle(5.5);
        c1.display();
        c2.display();

        // ---------- Person ----------
        System.out.println("
