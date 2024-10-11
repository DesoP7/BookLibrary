package system;

class Book {
    // Fields - private, only accessible within this class
    private long id;
    private String title;
    private String author;
    private int pages;
    private String isbn;
    private boolean borrowed;

    // Constructor to create a Book
    public Book(long id, String title, String author, int pages, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
        this.borrowed = false; // By default, the book is not borrowed
    }

    // Getters
    public long getId() {
        return id;
    }

    public boolean hasBeenBorrowed() {
        return borrowed;
    }

    // Returns title and author
    public String getTitleWithAuthor() {
        return title + " by " + author;
    }

    // toString method that returns all information of the book
    @Override
    public String toString() {
        return """
                Book ID: %d
                Title: %s
                Author: %s
                Pages: %d
                ISBN: %s
                Borrowed: %s
                """.formatted(id, title, author, pages, isbn, borrowed ? "Yes" : "No");
    }

    // Method to mark the book as borrowed
    public void borrowBook() {
        this.borrowed = true;
    }

    // Method to mark the book as returned
    public void returnBook() {
        this.borrowed = false;
    }
}
