package java_method;

import java.util.Scanner;

public class ShortestLongestWord {

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // stop when index goes out of range
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

        // Store indexes of spaces
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

        // Last word
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
            result[i][1] = String.valueOf(findLength(words[i])); // store length as String
        }
        return result;
    }

    // Method to find shortest and longest words
    // Returns {indexOfShortest, indexOfLongest}
    public static int[] findShortestLongest(String[][] wordLenArray) {
        int shortestIndex = 0, longestIndex = 0;

        for (int i = 1; i < wordLenArray.length; i++) {
            int len = Integer.parseInt(wordLenArray[i][1]);
            int shortestLen = Integer.parseInt(wordLenArray[shortestIndex][1]);
            int longestLen = Integer.parseInt(wordLenArray[longestIndex][1]);

            if (len < shortestLen) {
                shortestIndex = i;
            }
            if (len > longestLen) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Split words
        String[] words = customSplit(input);

        // Create 2D word-length array
        String[][] wordLenArray = wordWithLength(words);

        // Find shortest & longest
        int[] result = findShortestLongest(wordLenArray);
        int shortestIndex = result[0];
        int longestIndex = result[1];

        // Display results
        System.out.println("\nWord\t\tLength");
        System.out.println("-------------------------");
        for (int i = 0; i < wordLenArray.length; i++) {
            System.out.println(wordLenArray[i][0] + "\t\t" + Integer.parseInt(wordLenArray[i][1]));
        }

        System.out.println("\nShortest word: " + wordLenArray[shortestIndex][0] +
                " (Length: " + wordLenArray[shortestIndex][1] + ")");
        System.out.println("Longest word: " + wordLenArray[longestIndex][0] +
                " (Length: " + wordLenArray[longestIndex][1] + ")");

        sc.close();
    }
}

