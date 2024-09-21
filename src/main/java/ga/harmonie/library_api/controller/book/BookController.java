package ga.harmonie.library_api.controller.book;

import ga.harmonie.library_api.dto.BookDTO;
import ga.harmonie.library_api.entities.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BookController {

    @GetMapping("/books")
    ResponseEntity<List<BookDTO>> getAllBooks();

    @GetMapping("/books/language/{language}")
    ResponseEntity<List<BookDTO>> getAllBooksByLanguage(@PathVariable("language") String language);

    @GetMapping("/books/publisher/{publisher}")
    ResponseEntity<List<BookDTO>> getAllBooksByPublishers(@PathVariable("publisher") String publisher);

    @GetMapping("/books/author/{authorFullName}")
    ResponseEntity<List<BookDTO>> getAllBooksByAuthorFullName(@PathVariable("authorFullName") String authorFullName);

    @GetMapping("/books/genre/main/{genre}")
    ResponseEntity<List<BookDTO>> getAllBooksByMainType(@PathVariable("genre") String genre);

    @GetMapping("/book/{id}")
    ResponseEntity<BookDTO> getBookById(@PathVariable("id") long id);

    @GetMapping("/book/title/{title}")
    ResponseEntity<BookDTO> getBookByTitle(@PathVariable("title") String title);

    @GetMapping("/book/isbn/{isbn}")
    ResponseEntity<BookDTO> getBookByISBN(@PathVariable("isbn") String isbn);

    BookDTO bookToBookDTO(Book book);

    List<BookDTO> convertBooksListToBooksDTOList(List<Book> booksList);
}
