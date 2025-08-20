package java_method;

import java.util.Random;
import java.util.Scanner;

public class StudentVotingEligibility {

    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(90); // generate 2-digit number [10–99]
        }

        return ages;
    }

    // Method to check voting eligibility and return 2D array
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            result[i][0] = String.valueOf(age);

            if (age < 0) {
                result[i][1] = "false"; // negative = invalid
            } else if (age >= 18) {
                result[i][1] = "true"; // can vote
            } else {
                result[i][1] = "false"; // cannot vote
            }
        }

        return result;
    }

    // Method to display result in tabular format
    public static void displayResult(String[][] arr) {
        System.out.println("\nStudent Age\tCan Vote?");
        System.out.println("-----------------------------");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t\t" + arr[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Generate random ages
        int[] ages = generateAges(n);

        // Check voting eligibility
        String[][] eligibility = checkVotingEligibility(ages);

        // Display results
        displayResult(eligibility);

        sc.close();
    }
}

