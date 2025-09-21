package senario_based;

// File name: BookBazaar.java

import java.util.*;

// Interface for applying discounts
interface IDiscountable {
    double applyDiscount(int quantity);
}

// User class
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
}

// Base Book class
class Book implements IDiscountable {
    protected String title;
    protected String author;
    protected double price;
    private int stock; // encapsulated

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    // Getters and Setters
    public int getStock() {
        return stock;
    }

    public void updateStock(int quantity) {
        if (quantity >= 0 && quantity <= stock) {
            stock -= quantity;
        } else {
            System.out.println("Invalid quantity. Stock unchanged.");
        }
    }

    @Override
    public double applyDiscount(int quantity) {
        // Generic books have no discount
        return price * quantity;
    }

    public void showBook() {
        System.out.println(title + " by " + author + " | Price: $" + price + " | Stock: " + stock);
    }
}

// EBook class
class EBook extends Book {

    public EBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    @Override
    public double applyDiscount(int quantity) {
        // EBooks have 10% discount
        return (price * quantity) * 0.90;
    }
}

// PrintedBook class
class PrintedBook extends Book {

    public PrintedBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    @Override
    public double applyDiscount(int quantity) {
        // Printed books have 5% discount
        return (price * quantity) * 0.95;
    }
}

// Order class
class Order {
    private User user;
    private Map<Book, Integer> orderItems; // Book -> quantity
    private String orderStatus; // encapsulated

    public Order(User user) {
        this.user = user;
        this.orderItems = new HashMap<>();
        this.orderStatus = "Pending";
    }

    // Add book to order
    public void addBook(Book book, int quantity) {
        if (quantity > 0 && quantity <= book.getStock()) {
            orderItems.put(book, quantity);
            book.updateStock(quantity);
        } else {
            System.out.println("Cannot add book: invalid quantity or insufficient stock.");
        }
    }

    // Calculate total cost
    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Book, Integer> entry : orderItems.entrySet()) {
            total += entry.getKey().applyDiscount(entry.getValue());
        }
        return total;
    }

    // Update order status (internal)
    protected void setOrderStatus(String status) {
        this.orderStatus = status;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void showOrder() {
        System.out.println("Order for user: " + user.getName());
        for (Map.Entry<Book, Integer> entry : orderItems.entrySet()) {
            System.out.println("Book: " + entry.getKey().title + " | Quantity: " + entry.getValue() + " | Subtotal: $" + String.format("%.2f", entry.getKey().applyDiscount(entry.getValue())));
        }
        System.out.println("Total Cost: $" + String.format("%.2f", calculateTotal()));
        System.out.println("Order Status: " + orderStatus);
        System.out.println("----------------------------");
    }
}

// Main class
public class BookBazaar {
    public static void main(String[] args) {
        User alice = new User("Alice", "alice@example.com");

        // Create books
        Book book1 = new Book("Java Basics", "John Doe", 30, 10);
        EBook ebook1 = new EBook("Python Guide", "Jane Smith", 20, 50);
        PrintedBook pbook1 = new PrintedBook("Data Structures", "Alan Turing", 50, 5);

        // Show books
        book1.showBook();
        ebook1.showBook();
        pbook1.showBook();
        System.out.println("----------------------------");

        // Create order
        Order order1 = new Order(alice);
        order1.addBook(book1, 2);
        order1.addBook(ebook1, 3);
        order1.addBook(pbook1, 1);

        // Set order status internally
        order1.setOrderStatus("Confirmed");

        // Show order
        order1.showOrder();
    }
}

