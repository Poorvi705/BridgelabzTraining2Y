package Arrays;

import java.util.Scanner;

public class FootballTeamHeight {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] heights = new double[11];

        double sum = 0;

        // Taking height input
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        // Calculating sum
        for (int i = 0; i < heights.length; i++) {
            sum = sum + heights[i];
        }

        // Calculating mean
        double mean = sum / heights.length;

        System.out.println("Mean height of football team = " + mean);

        sc.close();
    }
}