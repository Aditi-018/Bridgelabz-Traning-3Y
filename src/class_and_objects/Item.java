package class_and_objects;

// File name: Item.java


public class Item {
    // Attributes
    int itemCode;
    String itemName;
    double price;

    // Constructor
    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayItemDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    // Method to calculate total cost for a given quantity
    public void calculateTotalCost(int quantity) {
        double total = price * quantity;
        System.out.println("Total cost for " + quantity + " units: " + total);
    }

    // main method
    public static void main(String[] args) {
        Item item1 = new Item(101, "Laptop", 45000.0);
        Item item2 = new Item(102, "Headphones", 1500.0);

        // Display item details
        item1.displayItemDetails();
        item1.calculateTotalCost(2); // e.g. 2 laptops

        System.out.println();

        item2.displayItemDetails();
        item2.calculateTotalCost(5); // e.g. 5 headphones
    }
}
