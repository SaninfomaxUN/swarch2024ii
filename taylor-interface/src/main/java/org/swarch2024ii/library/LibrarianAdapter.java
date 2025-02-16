package org.swarch2024ii.library;

public class LibrarianAdapter implements LibrarianInterface {
    private BookService bookService;

    public LibrarianAdapter(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void addBook(String title, String author) {
        bookService.addBook(title, author);
    }

    @Override
    public void removeBook(String title) {
        bookService.removeBook(title);
    }

    @Override
    public void listBooks() {
        bookService.listBooks();
    }
}