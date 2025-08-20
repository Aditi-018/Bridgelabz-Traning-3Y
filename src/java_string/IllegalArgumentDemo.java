package java_string;

import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to generate IllegalArgumentException
    public static void generateException(String text) {
        // start index > end index → IllegalArgumentException
        System.out.println("Substring with invalid range: " + text.substring(5, 2));
    }

    // Method to handle IllegalArgumentException using try-catch
    public static void handleException(String text) {
        try {
            // This will throw IllegalArgumentException
            System.out.println("Substring with invalid range: " + text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException! Reason: " + e.getMessage());
        } catch (RuntimeException e) {
            // Generic runtime exception handler
            System.out.println("Caught a RuntimeException! Reason: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = sc.next();

        // First: call method that generates exception
        System.out.println("\n--- Generating Exception ---");
        try {
            generateException(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        // Second: call method that handles exception
        System.out.println("\n--- Handling Exception ---");
        handleException(input);

        sc.close();
    }
}

