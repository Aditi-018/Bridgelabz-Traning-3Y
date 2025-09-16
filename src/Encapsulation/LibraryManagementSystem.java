package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Interface for reservable items
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method for loan duration
    public abstract int getLoanDuration(); // in days

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }

    // Encapsulation: getters and setters
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

// Book class
class Book extends LibraryItem implements Reservable {
    private boolean isReserved;
    private String borrowerName;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
        this.borrowerName = null;
    }

    @Override
    public int getLoanDuration() {
        return 21; // 21 days for books
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            this.borrowerName = borrowerName;
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book already reserved by " + this.borrowerName);
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    private boolean isReserved;
    private String borrowerName;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
        this.borrowerName = null;
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            this.borrowerName = borrowerName;
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine already reserved by " + this.borrowerName);
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private boolean isReserved;
    private String borrowerName;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
        this.borrowerName = null;
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days for DVDs
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            this.borrowerName = borrowerName;
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD already reserved by " + this.borrowerName);
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Main class to demonstrate polymorphism
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        Book book1 = new Book("B101", "Java Programming", "Alice");
        Magazine mag1 = new Magazine("M201", "Tech Today", "Bob");
        DVD dvd1 = new DVD("D301", "Inception", "Christopher Nolan");

        items.add(book1);
        items.add(mag1);
        items.add(dvd1);

        // Display item details using polymorphism
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Available: " + ((item instanceof Reservable) ? ((Reservable)item).checkAvailability() : "N/A"));
            System.out.println();
        }

        // Reserve some items
        System.out.println("--- Reserving Items ---");
        book1.reserveItem("John");
        mag1.reserveItem("Emma");
        dvd1.reserveItem("Mike");

        System.out.println();
        // Check availability after reservation
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + " available? " + ((item instanceof Reservable) ? ((Reservable)item).checkAvailability() : "N/A"));
        }
    }
}
