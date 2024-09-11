package ga.harmonie.library_api.repositories;

import ga.harmonie.library_api.entities.Author;
import ga.harmonie.library_api.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookById(long id);
    Optional<Book> findBookByTitle(String title);
    Optional<Book> findBookByIsbn(String isbn);
    List<Book> findBookByAuthor_FullName(String authorName);
    List<Book> findBookByPrice(Double price);
    List<Book> findBookByBookType_Title(String title);
    List<Book> findBookByLanguage(String language);
    List<Book> findBookByPublisher_PublisherName(String publisherName);

}
