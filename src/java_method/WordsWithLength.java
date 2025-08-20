package java_method;

import java.util.Scanner;

public class WordsWithLength {

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // stop when out of range
        }
        return count;
    }

    // Method to split string into words without using split()
    public static String[] customSplit(String str) {
        int length = findLength(str);

        // Count words (spaces + 1)
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Store space indexes
        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        // Extract words
        String[] words = new String[wordCount];
        int start = 0;
        idx = 0;

        for (int i = 0; i < spaceIndexes.length; i++) {
            int end = spaceIndexes[i];
            StringBuilder sb = new StringBuilder();
            for (int j = start; j < end; j++) {
                sb.append(str.charAt(j));
            }
            words[idx++] = sb.toString();
            start = end + 1;
        }

        // Add last word
        StringBuilder sb = new StringBuilder();
        for (int j = start; j < length; j++) {
            sb.append(str.charAt(j));
        }
        words[idx] = sb.toString();

        return words;
    }

    // Method to return 2D array [word, length]
    public static String[][] wordWithLength(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i])); // convert int → String
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Split words
        String[] words = customSplit(input);

        // Get 2D array
        String[][] wordLenArray = wordWithLength(words);

        // Display in tabular format
        System.out.println("\nWord\t\tLength");
        System.out.println("-------------------------");
        for (int i = 0; i < wordLenArray.length; i++) {
            String word = wordLenArray[i][0];
            int len = Integer.parseInt(wordLenArray[i][1]); // convert back to int
            System.out.println(word + "\t\t" + len);
        }

        sc.close();
    }
}
