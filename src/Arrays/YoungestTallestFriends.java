package Arrays;

import java.util.Scanner;

public class YoungestTallestFriends {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};

        int[] age = new int[3];
        double[] height = new double[3];

        // Taking input
        for (int i = 0; i < 3; i++) {

            System.out.print("Enter age of " + names[i] + ": ");
            age[i] = sc.nextInt();

            System.out.print("Enter height of " + names[i] + ": ");
            height[i] = sc.nextDouble();
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        // Finding youngest and tallest
        for (int i = 1; i < 3; i++) {

            if (age[i] < age[youngestIndex]) {
                youngestIndex = i;
            }

            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display result
        System.out.println("\nYoungest Friend: " + names[youngestIndex]);
        System.out.println("Age: " + age[youngestIndex]);

        System.out.println("\nTallest Friend: " + names[tallestIndex]);
        System.out.println("Height: " + height[tallestIndex]);
    }
}