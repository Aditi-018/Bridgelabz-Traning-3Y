package keywords;

// File name: ShoppingCartDemo.java

class Product {
    // Static variable shared across all products
    static double discount = 5.0;  // default discount in %

    // Final variable for unique product ID
    private final int productID;

    // Instance variables
    private String productName;
    private double price;
    private int quantity;

    // Constructor using 'this' keyword
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;       // 'this' resolves ambiguity
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate total price after discount
    public double calculateTotalPrice() {
        double total = price * quantity;
        return total - (total * discount / 100);
    }

    // Instance method to display product details (with instanceof check)
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID (final): " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount (static): " + discount + "%");
            System.out.println("Total Price after Discount: " + calculateTotalPrice());
        } else {
            System.out.println("Not a valid Product object.");
        }
    }

    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 100) {
            discount = newDiscount;
            System.out.println("Discount updated to: " + discount + "%");
        } else {
            System.out.println("Invalid discount value.");
        }
    }
}

// Main class
public class ShoppingCartDemo {
    public static void main(String[] args) {
        // Create products
        Product p1 = new Product(101, "Laptop", 50000, 1);
        Product p2 = new Product(102, "Headphones", 2000, 2);

        // Display details before discount change
        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();

        System.out.println("\n--- Updating Discount ---");
        // Update discount (static method)
        Product.updateDiscount(10);

        System.out.println();
        // Display details after discount change
        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();

        System.out.println();
        // instanceof demonstration
        if (p1 instanceof Product) {
            System.out.println("p1 is a valid Product instance.");
        }
    }
}
