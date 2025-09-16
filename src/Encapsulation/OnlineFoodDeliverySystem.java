package Encapsulation;

import java.util.ArrayList;
import java.util.List;

// Interface for discountable items
interface Discountable {
    void applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

// Abstract FoodItem class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method to calculate total price
    public abstract double calculateTotalPrice();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per Unit: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: $" + calculateTotalPrice());
        if(this instanceof Discountable) {
            System.out.println("Discount: " + ((Discountable)this).getDiscountDetails());
        }
        System.out.println();
    }

    // Encapsulation: getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    private double discount; // in percentage

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        total = total - (total * discount / 100);
        return total;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discount = discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return discount + "%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge; // extra charge per unit
    private double discount; // in percentage

    public NonVegItem(String itemName, double price, int quantity, double extraCharge) {
        super(itemName, price, quantity);
        this.extraCharge = extraCharge;
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        double total = (getPrice() + extraCharge) * getQuantity();
        total = total - (total * discount / 100);
        return total;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discount = discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return discount + "%";
    }
}

// Main class to demonstrate polymorphism
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        VegItem veg1 = new VegItem("Paneer Curry", 8, 2);
        NonVegItem nonVeg1 = new NonVegItem("Chicken Biryani", 12, 3, 2);

        // Apply discounts
        veg1.applyDiscount(10);        // 10% discount
        nonVeg1.applyDiscount(5);      // 5% discount

        // Add items to order
        order.add(veg1);
        order.add(nonVeg1);

        // Process order using polymorphism
        System.out.println("--- Order Details ---");
        for (FoodItem item : order) {
            item.getItemDetails();
        }
    }
}
