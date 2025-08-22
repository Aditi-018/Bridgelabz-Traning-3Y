package java_arrays;

import java.util.Scanner;

public class CharFrequency {

    // Method to find frequency of characters
    public static String[][] findCharFrequency(String text) {
        int[] freq = new int[256]; // frequency array for ASCII chars

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] > 0) {
                uniqueCount++;
                freq[text.charAt(i)] = -freq[text.charAt(i)]; // mark as processed
            }
        }

        // Prepare result array
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        // Reset frequency array for reuse
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] < 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(-freq[ch]);
                freq[ch] = 0; // reset to avoid duplicates
                index++;
            }
        }

        return result;
    }

    // Display the frequency result
    public static void displayFrequency(String[][] freqArray) {
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

        String[][] result = findCharFrequency(text);

        displayFrequency(result);
    }
}
