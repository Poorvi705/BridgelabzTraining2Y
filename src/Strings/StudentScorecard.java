package Strings;

import java.util.Scanner;

public class StudentScorecard {

    // Method to generate random 2-digit marks for Physics, Chemistry and Maths
    public static int[][] generateScores(int numberOfStudents) {

        int[][] scores = new int[numberOfStudents][3];

        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10; // Physics
            scores[i][1] = (int) (Math.random() * 90) + 10; // Chemistry
            scores[i][2] = (int) (Math.random() * 90) + 10; // Maths
        }

        return scores;
    }

    // Method to calculate total, average and percentage
    public static double[][] calculateResult(int[][] scores) {

        double[][] result = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {

            int total = scores[i][0] + scores[i][1] + scores[i][2];

            double average = total / 3.0;

            double percentage = (total / 300.0) * 100;

            // Round to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result;
    }

    // Method to calculate grade
    public static String[][] calculateGrade(double[][] result) {

        String[][] grades = new String[result.length][1];

        for (int i = 0; i < result.length; i++) {

            double percentage = result[i][2];

            if (percentage >= 80) {
                grades[i][0] = "A";
            } else if (percentage >= 70) {
                grades[i][0] = "B";
            } else if (percentage >= 60) {
                grades[i][0] = "C";
            } else if (percentage >= 50) {
                grades[i][0] = "D";
            } else if (percentage >= 40) {
                grades[i][0] = "E";
            } else {
                grades[i][0] = "R";
            }
        }

        return grades;
    }

    // Method to display the scorecard
    public static void displayScorecard(int[][] scores,
                                        double[][] result,
                                        String[][] grades) {

        System.out.println("\n---------------- STUDENT SCORECARD ----------------");

        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-12s %-8s%n",
                "Student", "Physics", "Chemistry", "Maths",
                "Total", "Average", "Percentage", "Grade");

        System.out.println(
                "--------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {

            System.out.printf("%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-12.2f %-8s%n",
                    (i + 1),
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    result[i][0],
                    result[i][1],
                    result[i][2],
                    grades[i][0]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        // Generate PCM scores
        int[][] scores = generateScores(numberOfStudents);

        // Calculate total, average and percentage
        double[][] result = calculateResult(scores);

        // Calculate grades
        String[][] grades = calculateGrade(result);

        // Display scorecard
        displayScorecard(scores, result, grades);

        sc.close();
    }
}