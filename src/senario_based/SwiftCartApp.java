package senario_based;

// File name: SwiftCartApp.java

import java.util.ArrayList;
import java.util.List;

// Interface for checkout actions
interface ICheckout {
    void generateBill();
    void applyDiscount(double coupon);
}

// Base Product class
abstract class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    // Polymorphic method to apply discount
    public abstract double applyDiscount(double price);
}

// Perishable Product
class PerishableProduct extends Product {
    public PerishableProduct(String name, double price) {
        super(name, price, "Perishable");
    }

    @Override
    public double applyDiscount(double price) {
        // Perishable items have 10% discount
        return price * 0.90;
    }
}

// Non-Perishable Product
class NonPerishableProduct extends Product {
    public NonPerishableProduct(String name, double price) {
        super(name, price, "Non-Perishable");
    }

    @Override
    public double applyDiscount(double price) {
        // Non-perishable items have 5% discount
        return price * 0.95;
    }
}

// Cart class
class Cart implements ICheckout {
    private List<Product> products;
    private List<Integer> quantities; // quantity of each product
    private double totalPrice;

    // Constructor without pre-selected items
    public Cart() {
        products = new ArrayList<>();
        quantities = new ArrayList<>();
        totalPrice = 0;
    }

    // Constructor with pre-selected items
    public Cart(List<Product> products, List<Integer> quantities) {
        this.products = products;
        this.quantities = quantities;
        calculateTotal();
    }

    // Add product to cart
    public void addProduct(Product p, int quantity) {
        products.add(p);
        quantities.add(quantity);
        calculateTotal();
        System.out.println(quantity + " x " + p.getName() + " added to cart.");
    }

    // Private method to calculate total price (encapsulation)
    private void calculateTotal() {
        totalPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            int qty = quantities.get(i);
            double priceWithDiscount = p.applyDiscount(p.getPrice());
            totalPrice += priceWithDiscount * qty; // operator *
        }
    }

    @Override
    public void generateBill() {
        System.out.println("\n---- SwiftCart Bill ----");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            int qty = quantities.get(i);
            double priceWithDiscount = p.applyDiscount(p.getPrice());
            System.out.println(p.getName() + " (" + qty + ") - ₹" + (priceWithDiscount * qty));
        }
        System.out.println("Total Price: ₹" + totalPrice);
    }

    @Override
    public void applyDiscount(double coupon) {
        totalPrice -= coupon; // operator -
        if (totalPrice < 0) totalPrice = 0;
        System.out.println("Applied coupon: ₹" + coupon + ". New Total: ₹" + totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

// Main App
public class SwiftCartApp {
    public static void main(String[] args) {
        // Create products
        Product milk = new PerishableProduct("Milk", 50);
        Product bread = new PerishableProduct("Bread", 40);
        Product soap = new NonPerishableProduct("Soap", 30);
        Product rice = new NonPerishableProduct("Rice", 80);

        // Create cart
        Cart cart = new Cart();
        cart.addProduct(milk, 2);
        cart.addProduct(bread, 1);
        cart.addProduct(soap, 3);
        cart.addProduct(rice, 1);

        // Generate bill
        cart.generateBill();

        // Apply coupon discount
        cart.applyDiscount(50);
    }
}
