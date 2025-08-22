package java_arrays;

import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and Status for one person
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0; // convert cm to meters
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 24.9) {
            status = "Normal";
        } else if (bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{
                String.format("%.1f", heightCm),
                String.format("%.1f", weight),
                String.format("%.2f", bmi),
                status
        };
    }

    // Method to compute BMI results for all people
    public static String[][] computeAllBMI(double[][] hwArray) {
        String[][] result = new String[hwArray.length][4];
        for (int i = 0; i < hwArray.length; i++) {
            result[i] = calculateBMI(hwArray[i][0], hwArray[i][1]);
        }
        return result;
    }

    // Method to display the table
    public static void displayResults(String[][] results) {
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------");
        for (String[] row : results) {
            System.out.printf("%-10s %-10s %-10s %-15s%n", row[0], row[1], row[2], row[3]);
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hwArray = new double[10][2]; // 10 rows, 2 cols (weight, height)

        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " - Weight (kg): ");
            hwArray[i][0] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " - Height (cm): ");
            hwArray[i][1] = sc.nextDouble();
        }

        // Compute BMI for all
        String[][] results = computeAllBMI(hwArray);

        // Display results
        displayResults(results);
    }
}
