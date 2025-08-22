package java_arrays;

import java.util.Scanner;

public class CharFrequencyWithUnique {

    // Method to find unique characters using charAt() and nested loops
    public static char[] uniqueCharacters(String text) {
        int n = text.length();
        char[] temp = new char[n]; // temporary array
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // check if it already appeared before
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create exact-sized array
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    // Method to find frequency of characters (with unique characters)
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256]; // ASCII range

        // Count frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Get unique characters
        char[] uniqueChars = uniqueCharacters(text);

        // Prepare result array
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(freq[ch]);
        }

        return result;
    }

    // Display the frequency result
    public static void displayResult(String[][] freqArray) {
        System.out.printf("%-10s %-10s%n", "Character", "Frequency");
        System.out.println("--------------------------");
        for (String[] row : freqArray) {
            System.out.printf("%-10s %-10s%n", row[0], row[1]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] result = findFrequency(text);

        displayResult(result);
    }
}
