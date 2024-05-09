package library;
public class LibraryController {
    private LibraryModel model;
    private LibraryView view;

    public LibraryController(LibraryModel model, LibraryView view) {
        this.model = model;
        this.view = view;
    }

    // Method to start the application
    public void start() {
        int choice;
        do {
            choice = view.displayMenu();
            switch (choice) {
                case 1:
                    String[] bookDetails = view.getBookDetails();
                    model.addBook(bookDetails[0], bookDetails[1]);
                    break;
                case 2:
                    model.displayBooks();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    // Main method
    public static void main(String[] args) {
        LibraryModel model = new LibraryModel();
        LibraryView view = new LibraryView();
        LibraryController controller = new LibraryController(model, view);
        controller.start();
    }
}

