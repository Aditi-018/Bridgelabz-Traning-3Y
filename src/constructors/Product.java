package constructors;

public class Product {
    // Instance variables
    private String productName;
    private double price;

    // Class variable (shared among all objects)
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // increase count whenever a new product is created
    }

    // Instance method
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName + ", Price: " + price);
    }

    // Class method (static)
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}
