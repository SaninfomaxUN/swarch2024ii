package org.swarch2024ii.library;

public class ReaderAdapter implements ReaderInterface {
    private BookService bookService;

    public ReaderAdapter(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void searchBookByTitle(String title) {
        bookService.searchBookByTitle(title);
    }

    @Override
    public void listBooks() {
        bookService.listBooks();
    }
}