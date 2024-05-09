package library;
import java.util.Scanner;

public class LibraryView {
    private Scanner scanner;

    public LibraryView() {
        scanner = new Scanner(System.in);
    }

    // Method to display menu options
    public int displayMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Display All Books");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    // Method to get book details from user
    public String[] getBookDetails() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        return new String[]{title, author};
    }
}


