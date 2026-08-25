package Strings;
public class NullPointerExceptionDemo {

    public static void generateException() {
        String text = null;

        // This will generate NullPointerException
        System.out.println(text.length());
    }

    public static void handleException() {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled");
            System.out.println("Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Uncomment this to generate the exception
        // generateException();

        // Method to handle the exception
        handleException();
    }
}
