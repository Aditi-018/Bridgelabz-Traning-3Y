package JavaControlFlows;

import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get input number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int originalNumber = number; // store original number
        int sum = 0;                 // to store sum of cubes of digits

        // Step 2: Loop through digits of the number
        while (originalNumber != 0) {
            int digit = originalNumber % 10;  // get last digit
            sum += digit * digit * digit;     // add cube of digit to sum
            originalNumber /= 10;             // remove last digit
        }

        // Step 3: Compare sum with original number
        if (sum == number) {
            System.out.println(number + " is an Armstrong Number");
        } else {
            System.out.println(number + " is NOT an Armstrong Number");
        }
    }
}

