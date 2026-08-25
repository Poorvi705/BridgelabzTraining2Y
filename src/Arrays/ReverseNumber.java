package Arrays;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;

        // Find number of digits
        int count = 0;

        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        int[] digits = new int[count];

        // Store digits
        temp = number;
        int index = 0;

        while (temp != 0) {

            digits[index] = temp % 10;

            index++;

            temp = temp / 10;
        }

        // Create reverse array
        int[] reverse = new int[count];

        for (int i = 0; i < count; i++) {
            reverse[i] = digits[count - 1 - i];
        }

        // Display original digits
        System.out.println("Digits:");

        for (int i = 0; i < count; i++) {
            System.out.print(digits[i] + " ");
        }

        // Display reverse array
        System.out.println("\nReverse:");

        for (int i = 0; i < count; i++) {
            System.out.print(reverse[i] + " ");
        }
    }
}