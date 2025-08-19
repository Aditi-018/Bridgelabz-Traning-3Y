package JavaControlFlows;

import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get input number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int count = 0;          // to store digit count
        int originalNumber = number; // store original number for output

        // Step 2: Loop until number becomes 0
        if (number == 0) {
            count = 1; // special case: 0 has 1 digit
        } else {
            while (number != 0) {
                number = number / 10; // remove last digit
                count++;              // increase count
            }
        }

        // Step 3: Display result
        System.out.println("The number " + originalNumber + " has " + count + " digits.");
    }
}
