package java_string;

import java.util.Scanner;

public class UpperCaseComparison {

    // Method to manually convert text to uppercase using charAt()
    public static String toUpperManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                // convert lowercase to uppercase by subtracting 32
                result += (char) (ch - 32);
            } else {
                // keep as is
                result += ch;
            }
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take full line input
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        // Manual conversion
        String manualUpper = toUpperManual(input);

        // Built-in conversion
        String builtInUpper = input.toUpperCase();

        // Compare results
        boolean isSame = compareStrings(manualUpper, builtInUpper);

        // Display results
        System.out.println("\n--- Uppercase Conversion ---");
        System.out.println("Manual Uppercase:   " + manualUpper);
        System.out.println("Built-in Uppercase: " + builtInUpper);
        System.out.println("Are both results same? " + isSame);

        sc.close();
    }
}

