package java_string;

import java.util.Scanner;

public class StringComparison {

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;  // If lengths are different, strings can't be equal
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;  // If any character is different
            }
        }
        return true; // Strings are equal
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter first string: ");
        String str1 = sc.next();

        System.out.print("Enter second string: ");
        String str2 = sc.next();

        // Manual comparison using charAt()
        boolean manualResult = compareStrings(str1, str2);

        // Built-in comparison using equals()
        boolean builtInResult = str1.equals(str2);

        // Display results
        System.out.println("\n--- String Comparison Results ---");
        System.out.println("Manual Comparison Result: " + manualResult);
        System.out.println("Built-in equals() Result: " + builtInResult);

        // Check if both results are same
        if (manualResult == builtInResult) {
            System.out.println("✅ Both methods give the same result.");
        } else {
            System.out.println("❌ Results are different!");
        }

        sc.close();
    }
}
