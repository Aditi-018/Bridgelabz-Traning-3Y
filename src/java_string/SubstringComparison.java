package java_string;
import java.util.Scanner;
public class SubstringComparison {




        // Method to create substring using charAt()
        public static String createSubstring(String str, int start, int end) {
            String result = "";
            for (int i = start; i < end; i++) {
                result += str.charAt(i);  // build substring manually
            }
            return result;
        }

        // Method to compare two strings using charAt()
        public static boolean compareStrings(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Take input string and indexes
            System.out.print("Enter a string: ");
            String text = sc.next();

            System.out.print("Enter start index: ");
            int start = sc.nextInt();

            System.out.print("Enter end index: ");
            int end = sc.nextInt();

            // Manual substring using charAt()
            String manualSubstring = createSubstring(text, start, end);

            // Built-in substring method
            String builtInSubstring = text.substring(start, end);

            // Compare both substrings using charAt()
            boolean comparisonResult = compareStrings(manualSubstring, builtInSubstring);

            // Display results
            System.out.println("\n--- Substring Results ---");
            System.out.println("Manual Substring: " + manualSubstring);
            System.out.println("Built-in Substring: " + builtInSubstring);
            System.out.println("Are both substrings same? " + comparisonResult);

            sc.close();
        }
    }


