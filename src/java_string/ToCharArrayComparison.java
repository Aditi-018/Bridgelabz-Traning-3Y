package java_string;

import java.util.Scanner;

public class ToCharArrayComparison {

    // Method to return characters in a string manually
    public static char[] getChars(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i); // manually copy characters
        }
        return chars;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // Method to display char array
    public static void displayCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Manual conversion
        char[] manualChars = getChars(text);

        // Built-in conversion
        char[] builtInChars = text.toCharArray();

        // Compare both
        boolean comparisonResult = compareCharArrays(manualChars, builtInChars);

        // Display results
        System.out.println("\n--- Character Array Results ---");
        System.out.print("Manual Char Array:   ");
        displayCharArray(manualChars);

        System.out.print("Built-in Char Array: ");
        displayCharArray(builtInChars);

        System.out.println("Are both char arrays same? " + comparisonResult);

        sc.close();
    }
}

