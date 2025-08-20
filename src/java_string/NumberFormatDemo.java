package java_string;

import java.util.Scanner;

public class NumberFormatDemo {

    // Method to generate NumberFormatException
    public static void generateException(String text) {
        // This will throw NumberFormatException if text is not numeric
        int number = Integer.parseInt(text);
        System.out.println("Converted number: " + number);
    }

    // Method to handle NumberFormatException using try-catch
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException! Reason: " + e.getMessage());
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

        // First: Call method that generates exception
        System.out.println("\n--- Generating Exception ---");
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        // Second: Call method that handles exception
        System.out.println("\n--- Handling Exception ---");
        handleException(input);

        sc.close();
    }
}
