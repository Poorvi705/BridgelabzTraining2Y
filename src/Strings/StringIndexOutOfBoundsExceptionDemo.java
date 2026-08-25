package Strings;
import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {

    public static void generateException(String text) {

        // Accessing index beyond the length of string
        System.out.println(text.charAt(text.length() + 1));
    }

    public static void handleException(String text) {

        try {
            System.out.println(text.charAt(text.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled");
            System.out.println("Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        // Uncomment to generate the exception
        // generateException(text);

        // Handle the exception
        handleException(text);

        sc.close();
    }
}