package java_arrays;

import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Iterative palindrome check using start and end indices
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive palindrome check
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Helper: Reverse string using charAt()
    public static char[] reverseString(String text) {
        int n = text.length();
        char[] reverse = new char[n];
        for (int i = 0; i < n; i++) {
            reverse[i] = text.charAt(n - 1 - i);
        }
        return reverse;
    }

    // Logic 3: Palindrome check using character arrays
    public static boolean isPalindromeCharArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Logic 1
        boolean result1 = isPalindromeIterative(text);
        System.out.println("Logic 1 (Iterative): " + (result1 ? "Palindrome" : "Not Palindrome"));

        // Logic 2
        boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);
        System.out.println("Logic 2 (Recursive): " + (result2 ? "Palindrome" : "Not Palindrome"));

        // Logic 3
        boolean result3 = isPalindromeCharArray(text);
        System.out.println("Logic 3 (Char Array): " + (result3 ? "Palindrome" : "Not Palindrome"));
    }
}

