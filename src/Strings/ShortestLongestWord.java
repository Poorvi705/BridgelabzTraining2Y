package Strings;
import java.util.Scanner;

public class ShortestLongestWord {

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

    public static String[][] getWordLength(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static int[] findShortestLongest(String[][] wordLength) {

        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < wordLength.length; i++) {

            int currentLength = Integer.parseInt(wordLength[i][1]);
            int shortestLength =
                    Integer.parseInt(wordLength[shortestIndex][1]);
            int longestLength =
                    Integer.parseInt(wordLength[longestIndex][1]);

            if (currentLength < shortestLength) {
                shortestIndex = i;
            }

            if (currentLength > longestLength) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = splitText(text);
        String[][] wordLength = getWordLength(words);

        int[] result = findShortestLongest(wordLength);

        int shortestIndex = result[0];
        int longestIndex = result[1];

        System.out.println("Shortest word: "
                + wordLength[shortestIndex][0]);

        System.out.println("Shortest word length: "
                + wordLength[shortestIndex][1]);

        System.out.println("Longest word: "
                + wordLength[longestIndex][0]);

        System.out.println("Longest word length: "
                + wordLength[longestIndex][1]);

        sc.close();
    }
}