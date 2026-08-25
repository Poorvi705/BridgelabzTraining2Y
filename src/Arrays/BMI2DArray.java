package Arrays;

import java.util.Scanner;

public class BMI2DArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking number of persons
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // 2D array:
        // column 0 = height
        // column 1 = weight
        // column 2 = BMI
        double[][] personData = new double[number][3];

        // Array to store weight status
        String[] weightStatus = new String[number];

        // Taking input for each person
        for (int i = 0; i < number; i++) {

            // Height
            System.out.print("Enter height of person " + (i + 1) + " in meters: ");
            double height = sc.nextDouble();

            while (height <= 0) {
                System.out.print("Invalid height. Enter a positive value: ");
                height = sc.nextDouble();
            }

            // Weight
            System.out.print("Enter weight of person " + (i + 1) + " in kg: ");
            double weight = sc.nextDouble();

            while (weight <= 0) {
                System.out.print("Invalid weight. Enter a positive value: ");
                weight = sc.nextDouble();
            }

            // Store height and weight
            personData[i][0] = height;
            personData[i][1] = weight;

            // Calculate BMI
            double bmi = weight / (height * height);

            // Store BMI
            personData[i][2] = bmi;

            // Determine weight status
            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display the results
        System.out.println("\n--- BMI Details ---");

        for (int i = 0; i < number; i++) {

            System.out.println("\nPerson " + (i + 1));
            System.out.println("Height: " + personData[i][0] + " m");
            System.out.println("Weight: " + personData[i][1] + " kg");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
        }

        sc.close();
    }
}