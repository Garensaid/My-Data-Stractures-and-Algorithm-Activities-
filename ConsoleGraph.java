import java.util.*;

// Book class
class Book {
    String title;
    String author;
    String genre;
    int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Publication Year: " + publicationYear;
    }
}

// Graph class for book relationships
class BookGraph {
    private Map<String, List<Book>> authorBooks;
    private Map<String, List<Book>> genreBooks;

    public BookGraph() {
        authorBooks = new HashMap<>();
        genreBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        authorBooks.computeIfAbsent(book.author, k -> new ArrayList<>()).add(book);
        genreBooks.computeIfAbsent(book.genre, k -> new ArrayList<>()).add(book);
    }

    public List<Book> getBooksByAuthor(String author) {
        return authorBooks.getOrDefault(author, Collections.emptyList());
    }

    public List<Book> getBooksByGenre(String genre) {
        return genreBooks.getOrDefault(genre, Collections.emptyList());
    }
}

// Hash table for book storage
class BookCatalog {
    private Map<String, Book> books;

    public BookCatalog() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.title, book);
    }

    public Book getBook(String title) {
        return books.get(title);
    }

    public void removeBook(String title) {
        books.remove(title);
    }

    public void displayAllBooks() {
        books.values().forEach(System.out::println);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        BookCatalog catalog = new BookCatalog();
        BookGraph graph = new BookGraph();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Search book");
            System.out.println("3. Display all books");
            System.out.println("4. Remove book");
            System.out.println("5. List books by author/genre");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook(catalog, graph, scanner);
                    break;
                case 2:
                    searchBook(catalog, scanner);
                    break;
                case 3:
                    catalog.displayAllBooks();
                    break;
                case 4:
                    removeBook(catalog, scanner);
                    break;
                case 5:
                    listBooks(graph, scanner);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addBook(BookCatalog catalog, BookGraph graph, Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book book = new Book(title, author, genre, publicationYear);
        catalog.addBook(book);
        graph.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void searchBook(BookCatalog catalog, Scanner scanner) {
        System.out.print("Enter title/author/genre: ");
        String query = scanner.nextLine();

        Book book = catalog.getBook(query);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found");
        }
    }

    private static void removeBook(BookCatalog catalog, Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        catalog.removeBook(title);
        System.out.println("Book removed successfully!");
    }

    private static void listBooks(BookGraph graph, Scanner scanner) {
        System.out.print("Enter author/genre: ");
        String query = scanner.nextLine();

        List<Book> books = graph.getBooksByAuthor(query);
        if (books.isEmpty()) {
            books = graph.getBooksByGenre(query);
        }

        if (!books.isEmpty()) {
            System.out.println("Books found:");
            books.forEach(System.out::println);
        } else {
            System.out.println("No books found");
        }
    }
}
