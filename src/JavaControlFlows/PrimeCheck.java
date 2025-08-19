package JavaControlFlows;
import java.util.Scanner;

public class PrimeCheck {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Input number
            System.out.print("Enter a number: ");
            int num = sc.nextInt();

            boolean isPrime = true; // assume number is prime

            if (num <= 1) {
                isPrime = false; // numbers <= 1 are not prime
            } else {
                // check divisibility
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false; // found a divisor
                        break;
                    }
                }
            }

            // Output
            if (isPrime) {
                System.out.println(num + " is a Prime Number");
            } else {
                System.out.println(num + " is NOT a Prime Number");
            }
        }
    }


