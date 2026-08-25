package Strings;

import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {

    public static void generateException(String[] names) {

        // Accessing an index beyond the array length
        System.out.println(names[names.length + 1]);
    }

    public static void handleException(String[] names) {

        try {
            System.out.println(names[names.length + 1]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled");
            System.out.println("Message: " + e.getMessage());

        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
            System.out.println("Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        // Uncomment to generate the exception
        // generateException(names);

        // Handle the exception
        handleException(names);

        sc.close();
    }
}