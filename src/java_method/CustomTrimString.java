package java_method;

import java.util.Scanner;

public class CustomTrimString {

    // Method to find start and end indices (ignoring leading/trailing spaces)
    public static int[] findTrimIndexes(String str) {
        int start = 0, end = 0;
        int length = 0;

        // Find length manually
        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // length found
        }

        // Find first non-space
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != ' ') {
                start = i;
                break;
            }
        }

        // Find last non-space
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                end = i;
                break;
            }
        }

        return new int[]{start, end};
    }

    // Method to create substring manually
    public static String customSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    // Method to compare two strings manually
    public static boolean customCompare(String str1, String str2) {
        int len1 = 0, len2 = 0;

        try {
            while (true) {
                str1.charAt(len1);
                len1++;
            }
        } catch (StringIndexOutOfBoundsException e) {}

        try {
            while (true) {
                str2.charAt(len2);
                len2++;
            }
        } catch (StringIndexOutOfBoundsException e) {}

        if (len1 != len2) return false;

        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string with spaces
        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        // Find trim indexes
        int[] indexes = findTrimIndexes(input);
        String customTrimmed = customSubstring(input, indexes[0], indexes[1]);

        // Built-in trim
        String builtInTrimmed = input.trim();

        // Compare
        boolean same = customCompare(customTrimmed, builtInTrimmed);

        // Display
        System.out.println("\nOriginal: >" + input + "<");
        System.out.println("Custom Trim: >" + customTrimmed + "<");
        System.out.println("Built-in Trim: >" + builtInTrimmed + "<");
        System.out.println("Are both same? " + same);

        sc.close();
    }
}

