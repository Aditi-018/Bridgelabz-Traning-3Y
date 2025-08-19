package JavaControlFlows;
import java.util.Scanner;

public class AbudantNumber {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Step 1: Input number
            System.out.print("Enter a number: ");
            int number = sc.nextInt();

            int sum = 0; // to store sum of divisors

            // Step 2: Loop through all divisors
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    sum += i; // add divisor
                }
            }

            // Step 3: Check condition
            if (sum > number) {
                System.out.println(number + " is an Abundant Number");
            } else {
                System.out.println(number + " is NOT an Abundant Number");
            }
        }
    }


