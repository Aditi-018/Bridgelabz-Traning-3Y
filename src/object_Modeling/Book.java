package object_Modeling;

public class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Display book details
    public void displayInfo() {
        System.out.println("Book: " + title + ", Author: " + author);
    }
}

