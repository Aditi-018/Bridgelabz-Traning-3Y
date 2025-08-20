package java_method;

import java.util.Scanner;

public class CustomSplitString {

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Stop when out of range
        }
        return count;
    }

    // Method to split string into words without using split()
    public static String[] customSplit(String str) {
        int length = findLength(str);

        // Count words (count spaces + 1)
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Store indexes of spaces
        int[] spaceIndexes = new int[wordCount - 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        // Extract words
        String[] words = new String[wordCount];
        int start = 0;
        index = 0;

        for (int i = 0; i < spaceIndexes.length; i++) {
            int end = spaceIndexes[i];
            StringBuilder sb = new StringBuilder();
            for (int j = start; j < end; j++) {
                sb.append(str.charAt(j));
            }
            words[index++] = sb.toString();
            start = end + 1;
        }

        // Add last word
        StringBuilder sb = new StringBuilder();
        for (int j = start; j < length; j++) {
            sb.append(str.charAt(j));
        }
        words[index] = sb.toString();

        return words;
    }

    // Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input with spaces
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Custom split
        String[] customWords = customSplit(input);

        // Built-in split
        String[] builtInWords = input.split(" ");

        // Compare results
        boolean isSame = compareArrays(customWords, builtInWords);

        // Display results
        System.out.println("\nCustom Split:");
        for (String word : customWords) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in Split:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nAre both results same? " + isSame);

        sc.close();
    }
}
