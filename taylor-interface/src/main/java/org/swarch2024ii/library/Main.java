package org.swarch2024ii.library;

public class Main {
    public static void main(String[] args) {
        // Instance of the generic service
        BookService bookService = new BookServiceImpl();

        // Tailored interfaces
        ReaderInterface reader = new ReaderAdapter(bookService);
        LibrarianInterface librarian = new LibrarianAdapter(bookService);

        // Reader operations
        System.out.println("=== Reader Operations ===");
        reader.listBooks();
        reader.searchBookByTitle("Don Quixote");

        // Librarian operations
        System.out.println("\n=== Librarian Operations ===");
        librarian.addBook("Don Quixote", "Miguel de Cervantes");
        librarian.addBook("One Hundred Years of Solitude", "Gabriel García Márquez");
        librarian.listBooks();
        librarian.removeBook("Don Quixote");
        librarian.listBooks();
    }
}
