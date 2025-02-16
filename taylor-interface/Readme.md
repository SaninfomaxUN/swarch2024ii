# Taylor Interface
**Repositorio:**   
[https://github.com/SaninfomaxUN/swarch2024ii](https://github.com/SaninfomaxUN/swarch2024ii)

**Instrucciones:**
1. Clone el repositorio.
2. Navegue a la carpeta `swarch2024ii/taylor-interface`.
3. Ejecute `mvn clean compile` para compilar el proyecto.
4. Luego ejecute `mvn exec:java` para ejecutar la aplicación principal.

---

## Escenario: Sistema de Gestión de Biblioteca
Supongamos que estamos desarrollando un sistema de gestión de bibliotecas. Tenemos diferentes tipos de usuarios (bibliotecarios, lectores y administradores), cada uno con diferentes necesidades. En lugar de exponer una interfaz genérica que todos usen, creamos interfaces adaptadas para cada rol.

### Paso 1: Definición de Interfaces Genéricas
Primero, definimos una interfaz genérica que representa las operaciones básicas de un libro:
```
public interface BookService {
    void addBook(String title, String author);
    void removeBook(String title);
    void listBooks();
    void searchBookByTitle(String title);
}
```
   
--- 

### Paso 2: Implementación de la Lógica del Servicio
Luego, implementamos la lógica del servicio que cumple con esta interfaz:
```
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
```
   
--- 

### Paso 3: Creación de Interfaces Adaptadas (Tailored Interfaces)
Ahora, creamos interfaces adaptadas para cada tipo de usuario:


### Interfaz para Lectores
Los lectores solo necesitan buscar y listar libros.
```
public interface ReaderInterface {
    void searchBookByTitle(String title);
    void listBooks();
}
```

### Interfaz para Bibliotecarios
Los bibliotecarios necesitan agregar, eliminar y listar libros.
```
public interface LibrarianInterface {
    void addBook(String title, String author);
    void removeBook(String title);
    void listBooks();
}
```
   
--- 

### Paso 4: Implementación de Adaptadores
Creamos adaptadores que implementan estas interfaces adaptadas utilizando el servicio genérico:


### Adaptador para Lectores


```
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
```



### Adaptador para Bibliotecarios

```
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
```
   
--- 

### Paso 5: Demostración en Acción
Finalmente, mostramos cómo se utiliza el sistema con las interfaces adaptadas.

```
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
```
   

--- 

### Salida Esperada
```
=== Reader Operations ===
No books available.
Book not found: Don Quixote

=== Librarian Operations ===
Book added: Don Quixote
Book added: One Hundred Years of Solitude
Book list:
Don Quixote - Miguel de Cervantes
One Hundred Years of Solitude - Gabriel García Márquez
Book removed: Don Quixote
Book list:
One Hundred Years of Solitude - Gabriel García Márquez
```
   
   
   
