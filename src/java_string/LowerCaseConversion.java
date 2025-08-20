package java_string;

import java.util.Scanner;

public class LowerCaseConversion {

    // Method to convert text to lowercase manually using ASCII values
    public static String convertToLowerCase(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If character is uppercase (A-Z), convert to lowercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32); // Add 32 to ASCII value
            }
            result.append(ch);
        }

        return result.toString();
    }

    // Method to compare two strings character by character
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.println("Enter a text: ");
        String input = sc.nextLine();

        // Convert using built-in method
        String builtinLower = input.toLowerCase();

        // Convert using user-defined method
        String manualLower = convertToLowerCase(input);

        // Compare both results
        boolean isEqual = compareStrings(builtinLower, manualLower);

        // Display results
        System.out.println("Built-in Lowercase Conversion : " + builtinLower);
        System.out.println("Manual Lowercase Conversion   : " + manualLower);
        System.out.println("Are both conversions equal? " + isEqual);

        sc.close();
    }
}

