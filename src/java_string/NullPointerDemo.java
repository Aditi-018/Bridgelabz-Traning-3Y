package java_string;

public class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;  // initialized to null
        // This will throw NullPointerException
        System.out.println("Length of text: " + text.length());
    }

    // Method to handle NullPointerException using try-catch
    public static void handleException() {
        String text = null;  // initialized to null
        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException! Reason: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Calling method that generates exception (unhandled)
        System.out.println("--- Generating Exception ---");
        try {
            generateException(); // This will stop execution if not caught
        } catch (NullPointerException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        // Calling method that handles exception inside itself
        System.out.println("\n--- Handling Exception ---");
        handleException();
    }
}

