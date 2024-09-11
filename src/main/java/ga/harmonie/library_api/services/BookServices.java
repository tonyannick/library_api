package ga.harmonie.library_api.services;

import ga.harmonie.library_api.entities.Author;
import ga.harmonie.library_api.entities.Book;
import ga.harmonie.library_api.entities.BookType;

import java.util.List;
import java.util.Optional;

public interface BookServices {

    Book addBook(Book book);
    BookType addBookType(BookType bookType);
    Optional<Book> updateBook(Book book);
    List<Book> getBooksByType(String type);
    List<Book> getBooksByPrice(Double price);
    List<Book> getAllBooksByAuthor(Author author);
    List<Book> getAllBooks();
    List<Book> getAllBooksByLanguage(String language);
    Optional<Book>findBookByTitle(String title);
    Optional<Book>findBookByIsbn(String isbn);
    Optional<BookType>findBookTypeByTitle(String title);
}
