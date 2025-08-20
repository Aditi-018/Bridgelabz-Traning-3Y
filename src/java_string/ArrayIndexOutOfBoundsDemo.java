package java_string;

import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {
        // Accessing invalid index (equal to length) → will throw exception
        System.out.println("Accessing element at index " + names.length + ": " + names[names.length]);
    }

    // Method to handle ArrayIndexOutOfBoundsException using try-catch
    public static void handleException(String[] names) {
        try {
            System.out.println("Accessing element at index " + names.length + ": " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException! Reason: " + e.getMessage());
        } catch (RuntimeException e) {
            // Generic runtime exception handler
            System.out.println("Caught a RuntimeException! Reason: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take array input from user
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        System.out.println("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        // First: Call method that generates exception (unhandled inside)
        System.out.println("\n--- Generating Exception ---");
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        // Second: Call method that handles exception internally
        System.out.println("\n--- Handling Exception ---");
        handleException(names);

        sc.close();
    }
}
