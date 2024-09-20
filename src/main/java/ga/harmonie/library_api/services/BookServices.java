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
    List<Book> getBooksByPrice(Double price);
    List<Book> getAllBooksByAuthor(String authorName);
    List<Book> getAllBooksByPublisher(String publisherName);
    List<Book> getAllBooks();
    List<Book> getAllBooksByLanguage(String language);
    List<Book>getAllBooksByMainType(String type);
    Optional<Book> findBookByTitle(String title);
    Optional<Book>findBookById(long id);
    Optional<Book>findBookByIsbn(String isbn);
    Optional<BookType>findBookTypeByTitle(String title);
}
