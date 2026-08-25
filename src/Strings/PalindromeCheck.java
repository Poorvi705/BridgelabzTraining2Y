package Strings;

import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Compare characters from start and end
    public static boolean palindromeUsingLoop(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // Logic 2: Recursive method
    public static boolean palindromeUsingRecursion(
            String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return palindromeUsingRecursion(text, start + 1, end - 1);
    }

    // Method to reverse string using charAt()
    public static char[] reverseString(String text) {

        char[] reverse = new char[text.length()];

        int index = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse[index] = text.charAt(i);
            index++;
        }

        return reverse;
    }

    // Logic 3: Compare original and reverse arrays
    public static boolean palindromeUsingArrays(String text) {

        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {

            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.next();

        // Logic 1
        boolean result1 = palindromeUsingLoop(text);

        // Logic 2
        boolean result2 = palindromeUsingRecursion(
                text, 0, text.length() - 1);

        // Logic 3
        boolean result3 = palindromeUsingArrays(text);

        System.out.println("\nPalindrome Check Results:");

        System.out.println("Using Loop: " + result1);
        System.out.println("Using Recursion: " + result2);
        System.out.println("Using Character Arrays: " + result3);

        sc.close();
    }
}