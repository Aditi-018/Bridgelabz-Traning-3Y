package inheritance;

// Save this file as OrderManagementSystem.java

// Base class
class Order {
    String orderId;
    String orderDate;

    // Constructor
    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to get status
    public String getOrderStatus() {
        return "Order Placed";
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

// Subclass: ShippedOrder
class ShippedOrder extends Order {
    String trackingNumber;

    // Constructor
    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped (Tracking: " + trackingNumber + ")";
    }

    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Subclass: DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    // Constructor
    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }

    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

// Main class
public class OrderManagementSystem {
    public static void main(String[] args) {
        // Base order
        Order order = new Order("ORD101", "2025-09-10");
        order.displayOrderDetails();
        System.out.println("-----------------------------");

        // Shipped order
        ShippedOrder shipped = new ShippedOrder("ORD102", "2025-09-11", "TRK12345");
        shipped.displayOrderDetails();
        System.out.println("-----------------------------");

        // Delivered order
        DeliveredOrder delivered = new DeliveredOrder("ORD103", "2025-09-12", "TRK67890", "2025-09-13");
        delivered.displayOrderDetails();
    }
}
