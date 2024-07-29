import java.util.Scanner;

public class URLShortenerApp {
    private static URLShortener urlShortener = new URLShortener();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    shortenURL();
                    break;
                case 2:
                    expandURL();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nURL Shortener Menu:");
        System.out.println("1. Shorten URL");
        System.out.println("2. Expand URL");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void shortenURL() {
        System.out.print("Enter the long URL to shorten: ");
        String longURL = scanner.nextLine();

        try {
            String shortURL = urlShortener.shortenURL(longURL);
            System.out.println("Shortened URL: " + shortURL);
        } catch (DuplicateUrlException e) {
            System.out.println("Error: Duplicate long URL detected.");
        }
    }

    private static void expandURL() {
        System.out.print("Enter the short URL to expand: ");
        String shortURL = scanner.nextLine();

        try {
            String expandedURL = urlShortener.expandURL(shortURL);
            System.out.println("Expanded URL: " + expandedURL);
        } catch (InvalidShortUrlException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


