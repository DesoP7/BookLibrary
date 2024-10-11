package nl.DesoP7;

import system.Library;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a Library instance
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Menu loop
        while (true) {
            // Display the menu options to the user
            System.out.println("Library System Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Show Book Details");
            System.out.println("4. Show All Books");
            System.out.println("5. Borrow a Book");
            System.out.println("6. Return a Book");
            System.out.println("7. Show Borrowed Books");
            System.out.println("8. Show Available Books");
            System.out.println("9. Exit");

            // Prompt the user for their choice
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left after the int input

            // Switch case to handle user input
            switch (choice) {
                case 1:
                    // Add a Book
                    System.out.print("Enter Book ID: ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter Number of Pages: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter Book ISBN: ");
                    String isbn = scanner.nextLine();

                    library.addBook(id, title, author, pages, isbn);
                    System.out.println("Book added successfully.\n");
                    break;

                case 2:
                    // Remove a Book
                    if (library.isLibraryEmpty()) {
                        System.out.println("There are no books in the library to remove.\n");
                    } else {
                        System.out.print("Enter Book ID to remove: ");
                        long removeId = scanner.nextLong();
                        library.removeBook(removeId);
                        System.out.println("Book removed successfully.\n");
                    }
                    break;

                case 3:
                    // Show Book Details
                    if (library.isLibraryEmpty()) {
                        System.out.println("There are no books in the library.\n");
                    } else {
                        System.out.print("Enter Book ID to show details: ");
                        long showId = scanner.nextLong();
                        System.out.println(library.showBook(showId));
                    }
                    break;

                case 4:
                    // Show All Books
                    if (library.isLibraryEmpty()) {
                        System.out.println("There are no books in the library.\n");
                    } else {
                        System.out.println("All Books:");
                        System.out.println(library.showBooks());
                    }
                    break;

                case 5:
                    // Borrow a Book
                    if (library.isLibraryEmpty()) {
                        System.out.println("There are no books in the library to borrow.\n");
                    } else {
                        System.out.print("Enter Book ID to borrow: ");
                        long borrowId = scanner.nextLong();
                        library.borrowBook(borrowId);
                        System.out.println("Book borrowed successfully.\n");
                    }
                    break;

                case 6:
                    // Return a Book
                    if (library.isLibraryEmpty()) {
                        System.out.println("There are no books to return.\n");
                    } else {
                        System.out.print("Enter Book ID to return: ");
                        long returnId = scanner.nextLong();
                        library.returnBook(returnId);
                        System.out.println("Book returned successfully.\n");
                    }
                    break;

                case 7:
                    // Show Borrowed Books
                    if (library.isLibraryEmpty()) {
                        System.out.println("There are no books that have been borrowed.\n");
                    } else {
                        System.out.println("Borrowed Books:");
                        System.out.println(library.showBorrowedBooks());
                    }
                    break;

                case 8:
                    // Show Available Books
                    if (library.isLibraryEmpty()) {
                        System.out.println("There are no books available in the library.\n");
                    } else {
                        System.out.println("Available Books:");
                        System.out.println(library.showAvailableBooks());
                    }
                    break;

                case 9:
                    // Exit the program
                    System.out.println("Exiting Library System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
}
