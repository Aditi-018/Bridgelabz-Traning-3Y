package java_method;

import java.util.Scanner;

public class VowelConsonantCounter {

    // Method to check if a character is vowel/consonant
    public static String checkChar(char ch) {
        // Convert uppercase → lowercase manually using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); // Convert to lowercase
        }

        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            // Check vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to count vowels and consonants
    // Returns int[] {vowelCount, consonantCount}
    public static int[] countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;

        int index = 0;
        try {
            while (true) {
                char ch = str.charAt(index);

                String type = checkChar(ch);
                if (type.equals("Vowel")) {
                    vowels++;
                } else if (type.equals("Consonant")) {
                    consonants++;
                }

                index++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Get counts
        int[] result = countVowelsConsonants(input);

        // Display
        System.out.println("\nVowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);

        sc.close();
    }
}

