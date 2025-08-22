package java_arrays;

import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length of string without using .length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // try accessing index
                count++;
            }
        } catch (Exception e) {
            // when index goes out of bound, stop
        }
        return count;
    }

    // Method to find unique characters using charAt()
    public static char[] findUniqueChars(String text) {
        int n = findLength(text);
        char[] temp = new char[n]; // temporary array
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // check if current char appeared before
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

        // Create final array of exact size
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }
        return uniqueChars;
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[] result = findUniqueChars(text);

        System.out.println("Unique characters in the string:");
        for (char c : result) {
            System.out.print(c + " ");
        }
    }
}
