package Strings;

import java.util.Scanner;

public class CharacterFrequencyUsingUnique {

    // Method to find unique characters
    public static char[] uniqueCharacters(String text) {

        char[] unique = new char[text.length()];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {

                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create new array with exact size
        char[] result = new char[uniqueCount];

        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }

        return result;
    }

    // Method to find frequency
    public static String[][] findFrequency(String text) {

        int[] frequency = new int[256];

        // Find frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Get unique characters
        char[] unique = uniqueCharacters(text);

        // Create 2D array
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(frequency[unique[i]]);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        String[][] result = findFrequency(text);

        System.out.println("Character\tFrequency");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }

        sc.close();
    }
}