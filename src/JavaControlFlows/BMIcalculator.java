package JavaControlFlows;

import java.util.Scanner;

public class BMIcalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input
        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();

        System.out.print("Enter height in cm: ");
        double heightCm = sc.nextDouble();

        // Step 2: Convert height to meters
        double heightM = heightCm / 100;

        // Step 3: Calculate BMI
        double bmi = weight / (heightM * heightM);

        // Step 4: Determine Status
        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        // Step 5: Display result
        System.out.println("\n--- BMI Result ---");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + heightCm + " cm");
        System.out.printf("BMI: %.2f\n", bmi); // formatted to 2 decimal places
        System.out.println("Status: " + status);
    }
}
