package object_Modeling;

import java.util.ArrayList;
import java.util.List;

// Main class
public class EcommercePlatform {

    // Product class
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    // Order class
    static class Order {
        private int orderId;
        private List<Product> products; // An order contains multiple products

        public Order(int orderId) {
            this.orderId = orderId;
            this.products = new ArrayList<>();
        }

        // Add product to order
        public void addProduct(Product product) {
            products.add(product);
        }

        // Show order details
        public void showOrderDetails() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Products in this order:");
            for (Product p : products) {
                System.out.println("- " + p.getName() + " : $" + p.getPrice());
            }
            System.out.println();
        }

        public double getTotalPrice() {
            double total = 0;
            for (Product p : products) {
                total += p.getPrice();
            }
            return total;
        }
    }

    // Customer class
    static class Customer {
        private String name;
        private List<Order> orders; // A customer can place multiple orders

        public Customer(String name) {
            this.name = name;
            this.orders = new ArrayList<>();
        }

        // Place an order
        public void placeOrder(Order order) {
            orders.add(order);
        }

        // Show all orders placed by customer
        public void showCustomerOrders() {
            System.out.println("Customer: " + name);
            for (Order o : orders) {
                o.showOrderDetails();
                System.out.println("Total Price: $" + o.getTotalPrice());
            }
            System.out.println("---------------\n");
        }
    }

    // Main method to demonstrate communication and aggregation
    public static void main(String[] args) {
        // Create products
        Product p1 = new Product("Laptop", 1200);
        Product p2 = new Product("Mouse", 25);
        Product p3 = new Product("Keyboard", 45);
        Product p4 = new Product("Headphones", 60);

        // Create orders
        Order order1 = new Order(101);
        order1.addProduct(p1);
        order1.addProduct(p2);

        Order order2 = new Order(102);
        order2.addProduct(p3);
        order2.addProduct(p4);

        // Create customers
        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        // Customers place orders
        c1.placeOrder(order1);
        c2.placeOrder(order2);

        // Show customer orders
        c1.showCustomerOrders();
        c2.showCustomerOrders();
    }
}

