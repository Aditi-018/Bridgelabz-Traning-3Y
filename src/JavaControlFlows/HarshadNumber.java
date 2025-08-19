package JavaControlFlows;

import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int sum = 0;
        int originalNumber = number;

        // Step 2: Find sum of digits
        while (number != 0) {
            int digit = number % 10;   // get last digit
            sum += digit;              // add to sum
            number /= 10;              // remove last digit
        }

        // Step 3: Check Harshad condition
        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad Number");
        } else {
            System.out.println(originalNumber + " is NOT a Harshad Number");
        }
    }
}
