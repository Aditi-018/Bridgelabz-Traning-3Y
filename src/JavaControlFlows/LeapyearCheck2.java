package JavaControlFlows;
import java.util.Scanner;

public class LeapyearCheck2 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a year: ");
            int year = sc.nextInt();

            if (year >= 1582 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
                System.out.println(year + " is a Leap Year");
            } else if (year >= 1582) {
                System.out.println(year + " is NOT a Leap Year");
            } else {
                System.out.println("Invalid input! Year must be >= 1582.");
            }
        }
    }


