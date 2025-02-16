package org.swarch2024ii.library;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private List<String> books = new ArrayList<>();

    @Override
    public void addBook(String title, String author) {
        books.add(title + " - " + author);
        System.out.println("Book added: " + title);
    }

    @Override
    public void removeBook(String title) {
        books.removeIf(book -> book.startsWith(title));
        System.out.println("Book removed: " + title);
    }

    @Override
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Book list:");
            books.forEach(System.out::println);
        }
    }

    @Override
    public void searchBookByTitle(String title) {
        boolean found = books.stream().anyMatch(book -> book.startsWith(title));
        if (found) {
            System.out.println("Book found: " + title);
        } else {
            System.out.println("Book not found: " + title);
        }
    }
}