package class_and_objects;

// File name: Book.java


public class Book {
    // attributes
    String title;
    String author;
    double price;

    // constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // method to display book details
    public void displayBookDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }

    // main method
    public static void main(String[] args) {
        Book book1 = new Book("2 States", "Chetan Bhagat", 500);
        Book book2 = new Book("Wings Of Fire", "A.P.J. Abdul Kalam", 500);

        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}
