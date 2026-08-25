package Strings;
import java.util.Scanner;

public class SplitText {

    public static int findLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] splitText(String text) {
        int length = findLength(text);
        int wordCount = 1;

        // Count the number of words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];

        int wordIndex = 0;
        String word = "";

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);

            if (ch == ' ') {
                words[wordIndex] = word;
                wordIndex++;
                word = "";
            } else {
                word = word + ch;
            }
        }

        words[wordIndex] = word;

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] userDefinedWords = splitText(text);
        String[] builtInWords = text.split(" ");

        System.out.println("\nWords using user-defined method:");

        for (String word : userDefinedWords) {
            System.out.println(word);
        }

        System.out.println("\nWords using split():");

        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nBoth results are same: "
                + compareArrays(userDefinedWords, builtInWords));

        sc.close();
    }
}
