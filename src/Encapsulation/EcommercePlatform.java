package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Interface for taxable products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method to calculate discount
    public abstract double calculateDiscount();

    // Getters and Setters (Encapsulation)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to calculate final price (price + tax - discount)
    public void showFinalPrice() {
        double discount = calculateDiscount();
        double tax = (this instanceof Taxable) ? ((Taxable)this).calculateTax() : 0;
        double finalPrice = getPrice() + tax - discount;

        System.out.println("Product: " + getName());
        System.out.println("Base Price: $" + getPrice());
        if (tax > 0) System.out.println("Tax: $" + tax + " (" + ((Taxable)this).getTaxDetails() + ")");
        System.out.println("Discount: $" + discount);
        System.out.println("Final Price: $" + finalPrice);
        System.out.println();
    }
}

// Electronics class (taxable)
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15; // 15% tax
    }

    @Override
    public String getTaxDetails() {
        return "15% Electronics Tax";
    }
}

// Clothing class (taxable)
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    @Override
    public String getTaxDetails() {
        return "5% Clothing Tax";
    }
}

// Groceries class (non-taxable)
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class to demonstrate polymorphism
public class EcommercePlatformDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 1200));
        products.add(new Clothing(102, "T-Shirt", 50));
        products.add(new Groceries(103, "Rice Pack", 30));

        // Polymorphism: each product calculates and displays final price
        for (Product p : products) {
            p.showFinalPrice();
        }
    }
}
