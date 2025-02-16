package org.swarch2024ii.library;

public interface BookService {
    void addBook(String title, String author);
    void removeBook(String title);
    void listBooks();
    void searchBookByTitle(String title);
}
