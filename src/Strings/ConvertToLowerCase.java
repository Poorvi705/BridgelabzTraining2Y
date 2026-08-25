package Strings;

import java.util.Scanner;

public class ConvertToLowerCase {

    public static String convertToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }

            result = result + ch;
        }

        return result;
    }

    public static boolean compareStrings(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter complete text: ");
        String text = sc.nextLine();

        String userDefinedResult = convertToLowerCase(text);
        String builtInResult = text.toLowerCase();

        System.out.println("Using user-defined method: "
                + userDefinedResult);

        System.out.println("Using toLowerCase(): "
                + builtInResult);

        System.out.println("Both results are same: "
                + compareStrings(userDefinedResult, builtInResult));

        sc.close();
    }
}