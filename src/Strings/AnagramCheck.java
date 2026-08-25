package Strings;

import java.util.Scanner;

public class AnagramCheck {

    public static boolean checkAnagram(String text1, String text2) {

        // Check lengths
        if (text1.length() != text2.length()) {
            return false;
        }

        // Arrays to store frequency
        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];

        // Find frequency of first text
        for (int i = 0; i < text1.length(); i++) {
            char ch = text1.charAt(i);
            frequency1[ch]++;
        }

        // Find frequency of second text
        for (int i = 0; i < text2.length(); i++) {
            char ch = text2.charAt(i);
            frequency2[ch]++;
        }

        // Compare frequencies
        for (int i = 0; i < 256; i++) {

            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = sc.next();

        System.out.print("Enter second text: ");
        String text2 = sc.next();

        boolean result = checkAnagram(text1, text2);

        if (result) {
            System.out.println("The two texts are Anagrams.");
        } else {
            System.out.println("The two texts are not Anagrams.");
        }

        sc.close();
    }
}