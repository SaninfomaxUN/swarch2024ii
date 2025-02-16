package org.swarch2024ii.library;

public interface LibrarianInterface {
    void addBook(String title, String author);
    void removeBook(String title);
    void listBooks();
}