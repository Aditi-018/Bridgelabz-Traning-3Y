package constructors;

// Base class
class Book {
    public String ISBN;       // public
    protected String title;   // protected
    private String author;    // private

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Getter for author (private -> accessed via public method)
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title + ", Author: " + author);
    }
}

// Subclass
class EBook extends Book {
    private double fileSizeMB;

    public EBook(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public void displayEBookDetails() {
        // Accessing public ISBN directly
        // Accessing protected title directly
        System.out.println("EBook ISBN: " + ISBN +
                ", Title: " + title +
                ", Author: " + getAuthor() +
                ", File Size: " + fileSizeMB + " MB");
    }
}

// Demo Class
public class LibraryDemo {
    public static void main(String[] args) {
        // Create a Book
        Book b1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        b1.displayBookDetails();

        // Update author
        b1.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + b1.getAuthor());

        // Create an EBook
        EBook eb1 = new EBook("978-0596009205", "Head First Java", "Kathy Sierra", 15.6);
        eb1.displayEBookDetails();
    }
}
