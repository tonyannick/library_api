package ga.harmonie.library_api.services.implementation;

import ga.harmonie.library_api.entities.Author;
import ga.harmonie.library_api.entities.Book;
import ga.harmonie.library_api.entities.BookType;
import ga.harmonie.library_api.repositories.BookRepository;
import ga.harmonie.library_api.repositories.BookTypeRepository;
import ga.harmonie.library_api.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Order(value = 1)
public class BookServicesImpl implements BookServices {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookTypeRepository bookTypeRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public BookType addBookType(BookType bookType) {
        return bookTypeRepository.save(bookType);
    }

    @Override
    public Optional<Book> updateBook(Book book) {
        Optional<Book> bookToFind = bookRepository.findById(book.getId());
        if(bookToFind.isPresent()){
            bookToFind.get().setTitle(book.getTitle());
            bookToFind.get().setIsbn(book.getIsbn());
            bookToFind.get().setPages(book.getPages());
            bookToFind.get().setPrice(book.getPrice());
            var updatedBook = bookRepository.save(bookToFind.get());
            return Optional.of(updatedBook);
        }
        return Optional.empty();
    }

    @Override
    public List<Book> getBooksByType(String type) {
        return bookRepository.findBookByBookType_Title(type);
    }

    @Override
    public List<Book> getBooksByPrice(Double price) {
        return bookRepository.findBookByPrice(price);
    }

    @Override
    public List<Book> getAllBooksByAuthor(String authorName) {
        return bookRepository.findBookByAuthor_FullName(authorName);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    @Override
    public List<Book> getAllBooksByLanguage(String language) {
        return bookRepository.findBookByLanguage(language);
    }

    @Override
    public List<Book> getAllBooksByPublisher(String publisherName) {
        return bookRepository.findBookByPublisher_PublisherName(publisherName);
    }

    @Override
    public Optional<Book> findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    @Override
    public Optional<Book> findBookById(long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public Optional<BookType> findBookTypeByTitle(String title) {
        return bookTypeRepository.findDistinctFirstByTitle(title);
    }
}
