package java_method;

import java.util.Scanner;

public class StringLengthWithoutLength {

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // keep accessing characters
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception will break the loop when index goes out of range
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input string
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Using custom method
        int customLength = findLength(input);

        // Using built-in method
        int builtInLength = input.length();

        // Display results
        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);

        sc.close();
    }
}

