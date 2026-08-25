import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        long temp = number;

        // Count number of digits
        int count = 0;

        if (temp == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                temp = temp / 10;
                count++;
            }
        }

        // Store digits in an array
        int[] digits = new int[count];

        temp = number;

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = (int) (temp % 10);
            temp = temp / 10;
        }

        // Frequency array for digits 0-9
        int[] frequency = new int[10];

        // Calculate frequency
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        // Display frequency
        System.out.println("\nFrequency of each digit:");

        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + " = " + frequency[i]);
            }
        }

        sc.close();
    }
}