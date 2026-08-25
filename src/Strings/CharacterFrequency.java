package Strings;

import java.util.Scanner;

public class CharacterFrequency {

    public static String[][] findCharacterFrequency(String text) {

        int[] frequency = new int[256];

        // Find frequency using charAt()
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Count characters which occur
        int count = 0;

        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                count++;
            }
        }

        // Create 2D array
        String[][] result = new String[count][2];

        int index = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            // Add character only first time
            boolean alreadyAdded = false;

            for (int j = 0; j < index; j++) {
                if (result[j][0].charAt(0) == ch) {
                    alreadyAdded = true;
                    break;
                }
            }

            if (!alreadyAdded) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        String[][] result = findCharacterFrequency(text);

        System.out.println("Character\tFrequency");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }

        sc.close();
    }
}