package java_string;

import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {
        // Accessing invalid index -> will throw exception
        System.out.println("Character at index " + text.length() + ": " + text.charAt(text.length()));
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String text) {
        try {
            // Accessing invalid index
            System.out.println("Character at index " + text.length() + ": " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException! Reason: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Calling method that generates exception (unhandled)
        System.out.println("\n--- Generating Exception ---");
        try {
            generateException(input);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        // Calling method that handles exception
        System.out.println("\n--- Handling Exception ---");
        handleException(input);

        sc.close();
    }
}
