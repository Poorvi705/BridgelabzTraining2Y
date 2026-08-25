package Strings;

import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and status
    public static String[] calculateBMI(double weight, double height) {

        // Convert height from cm to meter
        double heightInMeter = height / 100;

        // Calculate BMI
        double bmi = weight / (heightInMeter * heightInMeter);

        // Round BMI to 2 decimal places
        bmi = Math.round(bmi * 100.0) / 100.0;

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

        return new String[]{
                String.valueOf(height),
                String.valueOf(weight),
                String.valueOf(bmi),
                status
        };
    }

    // Method to calculate BMI for all persons
    public static String[][] calculateAllBMI(double[][] data) {

        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {

            // First column = weight
            double weight = data[i][0];

            // Second column = height
            double height = data[i][1];

            String[] bmiResult = calculateBMI(weight, height);

            result[i][0] = bmiResult[0]; // Height
            result[i][1] = bmiResult[1]; // Weight
            result[i][2] = bmiResult[2]; // BMI
            result[i][3] = bmiResult[3]; // Status
        }

        return result;
    }

    // Method to display the result in tabular format
    public static void displayResult(String[][] result) {

        System.out.println("\n---------------- BMI SCORECARD ----------------");

        System.out.printf("%-10s %-10s %-10s %-15s%n",
                "Height(cm)", "Weight(kg)", "BMI", "Status");

        System.out.println("-----------------------------------------------");

        for (int i = 0; i < result.length; i++) {

            System.out.printf("%-10s %-10s %-10s %-15s%n",
                    result[i][0],
                    result[i][1],
                    result[i][2],
                    result[i][3]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 10 persons, 2 columns
        // Column 0 = Weight
        // Column 1 = Height
        double[][] data = new double[10][2];

        // Take input
        for (int i = 0; i < 10; i++) {

            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight in kg: ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height in cm: ");
            data[i][1] = sc.nextDouble();
        }

        // Calculate BMI and status
        String[][] result = calculateAllBMI(data);

        // Display result
        displayResult(result);

        sc.close();
    }
}