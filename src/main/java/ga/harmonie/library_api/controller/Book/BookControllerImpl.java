package ga.harmonie.library_api.controller.Book;

import ga.harmonie.library_api.dto.BookDTO;
import ga.harmonie.library_api.entities.Book;
import ga.harmonie.library_api.mapper.BookMapper;
import ga.harmonie.library_api.services.BookServices;
import ga.harmonie.library_api.services.PublisherServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("library")
public class BookControllerImpl implements BookController{

    private static final Logger logger = LoggerFactory.getLogger(BookControllerImpl.class);

    @Autowired
    BookServices bookServices;
    @Autowired
    PublisherServices publisherServices;
    @Autowired
    BookMapper bookMapper;

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        var booksList = bookServices.getAllBooks();
        var bookDTOList = convertBooksListToBooksDTOList(booksList);
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooksByLanguage(String language) {
        var booksList = bookServices.getAllBooksByLanguage(language);
        var bookDTOList = convertBooksListToBooksDTOList(booksList);
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooksByPublishers(String publisher) {
        var booksList = bookServices.getAllBooksByPublisher(publisher);
        var bookDTOList = convertBooksListToBooksDTOList(booksList);
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooksByAuthorFullName(String authorFullName) {
        var authorBooksList = bookServices.getAllBooksByAuthor(authorFullName);
        var bookDTOList = convertBooksListToBooksDTOList(authorBooksList);
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooksByMainType(String genre) {
        var booksList = bookServices.getAllBooksByMainType(genre);
        var bookDTOList = convertBooksListToBooksDTOList(booksList);
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookDTO> getBookById(long id) {
        var optionalBook =  bookServices.findBookById(id);
        return optionalBook.map(book -> ResponseEntity.ok().body(bookToBookDTO(book))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<BookDTO> getBookByTitle(String title) {
        var optionalBook = bookServices.findBookByTitle(title);
        if(optionalBook.isPresent()){
            return ResponseEntity.ok().body(bookToBookDTO(optionalBook.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<BookDTO> getBookByISBN(String isbn) {
        var optionalBook = bookServices.findBookByIsbn(isbn);
        if(optionalBook.isPresent()){
            return ResponseEntity.ok().body(bookToBookDTO(optionalBook.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public BookDTO bookToBookDTO(Book book) {
        var author = book.getAuthor();
        var bookType = book.getBookType();
        var publisher = book.getPublisher();
        return bookMapper.INSTANCE.toBookDTO(book,author,bookType,publisher);
    }
    @Override
    public List<BookDTO> convertBooksListToBooksDTOList(List<Book> booksList){
        var bookDTOList = new ArrayList<BookDTO>();
        booksList.forEach(book -> bookDTOList.add(bookToBookDTO(book)));
        return bookDTOList;
    }
}
