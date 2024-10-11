package system;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(long id, String title, String author, int pages, String isbn) {
        Book newBook = new Book(id, title, author, pages, isbn);
        books.add(newBook);
    }

    // Method to remove a book by its ID
    public void removeBook(long id) {
        books.removeIf(book -> book.getId() == id);
    }

    // Method to show the details of a specific book by ID
    public String showBook(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book.toString();  // Calls the Book's toString() method
            }
        }
        return "Book not found!";
    }

    // Method to borrow a book by its ID
    public void borrowBook(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.hasBeenBorrowed()) {
                    book.borrowBook();
                    System.out.println("The book has been borrowed.");
                } else {
                    System.out.println("The book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Method to return a book by its ID
    public void returnBook(long id) {
        boolean foundBorrowedBook = false;
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.hasBeenBorrowed()) {
                    book.returnBook();
                    foundBorrowedBook = true;
                    System.out.println("The book has been returned.");
                } else {
                    System.out.println("This book wasn't borrowed.");
                }
                return;
            }
        }
        if (!foundBorrowedBook) {
            System.out.println("Book not found or wasn't borrowed.");
        }
    }

    // Method to show all books in the library
    public String showBooks() {
        if (books.isEmpty()) {
            return "No books in the library.";
        }

        StringBuilder allBooks = new StringBuilder();
        for (Book book : books) {
            allBooks.append(book.getTitleWithAuthor()).append("\n");
        }
        return allBooks.toString();
    }

    // Method to show all borrowed books
    public String showBorrowedBooks() {
        StringBuilder borrowedBooks = new StringBuilder();
        boolean borrowedFound = false;
        for (Book book : books) {
            if (book.hasBeenBorrowed()) {
                borrowedBooks.append(book.getTitleWithAuthor()).append("\n");
                borrowedFound = true;
            }
        }
        if (!borrowedFound) {
            return "No books are currently borrowed.";
        }
        return borrowedBooks.toString();
    }

    // Method to show all available (not borrowed) books
    public String showAvailableBooks() {
        StringBuilder availableBooks = new StringBuilder();
        boolean availableFound = false;
        for (Book book : books) {
            if (!book.hasBeenBorrowed()) {
                availableBooks.append(book.getTitleWithAuthor()).append("\n");
                availableFound = true;
            }
        }
        if (!availableFound) {
            return "No books are currently available.";
        }
        return availableBooks.toString();
    }

    // Method to check if the library is empty
    public boolean isLibraryEmpty() {
        return books.isEmpty();
    }
}
