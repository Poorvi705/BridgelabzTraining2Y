package Strings;
import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    public static void generateException(String text) {

        // Start index is greater than end index
        System.out.println(text.substring(5, 2));
    }

    public static void handleException(String text) {

        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled");
            System.out.println("Message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
            System.out.println("Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with at least 6 characters: ");
        String text = sc.next();

        // Uncomment to generate the exception
        // generateException(text);

        // Handle the exception
        handleException(text);

        sc.close();
    }
}