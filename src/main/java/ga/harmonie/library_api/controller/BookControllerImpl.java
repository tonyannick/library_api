package ga.harmonie.library_api.controller;

import ga.harmonie.library_api.dto.BookDTO;
import ga.harmonie.library_api.entities.Author;
import ga.harmonie.library_api.entities.Book;
import ga.harmonie.library_api.mapper.BookMapper;
import ga.harmonie.library_api.services.BookServices;
import ga.harmonie.library_api.services.PublisherServices;
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

    @Autowired
    BookServices bookServices;
    @Autowired
    PublisherServices publisherServices;
    @Autowired
    BookMapper bookMapper;

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        var booksList = bookServices.getAllBooks();
        var bookDTOList = new ArrayList<BookDTO>();
        booksList.forEach(book ->
            bookDTOList.add(bookToBookDTO(book)));
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooksByLanguage(String language) {
        var booksList = bookServices.getAllBooksByLanguage(language);
        var bookDTOList = new ArrayList<BookDTO>();
        booksList.forEach(book ->
                bookDTOList.add(bookToBookDTO(book)));
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooksByPublishers(String publisher) {
        return null;
    }

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooksByAuthorFullName(String authorFullName) {
        var author = new Author.Builder()
                .fullName(authorFullName)
                .build();
        var authorBooksList = bookServices.getAllBooksByAuthor(author);
        var bookDTOList = new ArrayList<BookDTO>();
        authorBooksList.forEach(book ->
                bookDTOList.add(bookToBookDTO(book)));
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooksByGenre(String genre) {
        var booksList = bookServices.getBooksByType(genre);
        var bookDTOList = new ArrayList<BookDTO>();
        booksList.forEach(book ->
                bookDTOList.add(bookToBookDTO(book)));
        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookDTO> getBookById(long id) {
        return null;
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
    public BookDTO bookToBookDTO(Book book) {
        var author = book.getAuthor();
        var bookType = book.getBookType();
        var publisher = book.getPublisher();
        return bookMapper.INSTANCE.toBookDTO(book,author,bookType,publisher);
    }
}
