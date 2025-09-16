package programing_practices;

public class LibrarySystemDemo {
}// File name: LibrarySystemDemo.java

class Book {
    // Static variable shared across all books
    static String libraryName = "Central Library";

    // Final variable for unique identifier
    private final String isbn;

    // Instance variables
    private String title;
    private String author;

    // Constructor using 'this' keyword
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;       // 'this' resolves ambiguity
        this.title = title;
        this.author = author;
    }

    // Instance method to display book details (with instanceof check)
    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Library (static): " + libraryName);
            System.out.println("ISBN (final): " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        } else {
            System.out.println("Not a valid Book object.");
        }
    }

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
}

// Main class
public class LibrarySystemDemo {
    public static void main(String[] args) {
        // Create Book objects
        Book b1 = new Book("ISBN101", "Java Programming", "James Gosling");
        Book b2 = new Book("ISBN102", "Data Structures", "Robert Lafore");

        // Display library name (static method)
        Book.displayLibraryName();
        System.out.println();

        // Display book details
        b1.displayBookDetails();
        System.out.println();
        b2.displayBookDetails();

        System.out.println();

        // instanceof demonstration
        if (b1 instanceof Book) {
            System.out.println("b1 is a valid Book instance.");
        }
    }
}

