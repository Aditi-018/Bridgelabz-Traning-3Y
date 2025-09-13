package inheritance;

// Save this file as LibraryManagement.java

// Superclass: Book
class Book {
    String title;
    int publicationYear;

    // Constructor
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book info
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass: Author
class Author extends Book {
    String authorName;
    String bio;

    // Constructor
    Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear); // Call superclass constructor
        this.authorName = authorName;
        this.bio = bio;
    }

    // Overriding method to display full details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call Book's displayInfo
        System.out.println("Author: " + authorName);
        System.out.println("Bio: " + bio);
        System.out.println("--------------------------------");
    }
}

// Main class
public class LibraryManagement {
    public static void main(String[] args) {
        // Create Author object (with book + author details)
        Author book1 = new Author(
                "The Great Gatsby",
                1925,
                "F. Scott Fitzgerald",
                "American novelist known for his depiction of the Jazz Age."
        );

        Author book2 = new Author(
                "Wings of Fire",
                1999,
                "A.P.J. Abdul Kalam",
                "Former President of India and a renowned aerospace scientist."
        );

        // Display info
        book1.displayInfo();
        book2.displayInfo();
    }
}
