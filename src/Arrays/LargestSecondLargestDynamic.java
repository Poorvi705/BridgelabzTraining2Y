package Arrays;

import java.util.Scanner;

public class LargestSecondLargestDynamic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        int index = 0;

        // Store digits
        while (number != 0) {

            // Increase array size if required
            if (index == maxDigit) {

                maxDigit = maxDigit + 10;

                int[] temp = new int[maxDigit];

                // Copy old array into temp
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                digits = temp;
            }

            int digit = number % 10;

            digits[index] = digit;

            index++;

            number = number / 10;
        }

        int largest = -1;
        int secondLargest = -1;

        // Find largest and second largest
        for (int i = 0; i < index; i++) {

            if (digits[i] > largest) {

                secondLargest = largest;
                largest = digits[i];

            } else if (digits[i] > secondLargest && digits[i] != largest) {

                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}