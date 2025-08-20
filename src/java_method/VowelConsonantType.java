package java_method;

import java.util.Scanner;

public class VowelConsonantType {

    // Method to check if character is vowel, consonant or not a letter
    public static String checkChar(char ch) {
        // Convert uppercase → lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to create a 2D array [char, type]
    public static String[][] analyzeString(String str) {
        int length = 0;

        // Find length without length() by charAt()
        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string
        }

        String[][] result = new String[length][2];

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);   // store character
            result[i][1] = checkChar(ch);        // store type
        }

        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayResult(String[][] arr) {
        System.out.println("\nCharacter\tType");
        System.out.println("-------------------------");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t\t" + arr[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Analyze
        String[][] result = analyzeString(input);

        // Display
        displayResult(result);

        sc.close();
    }
}
