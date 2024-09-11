package ga.harmonie.library_api.repositories;

import ga.harmonie.library_api.entities.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookTypeRepository extends JpaRepository<BookType, Long> {

    Optional<BookType> findDistinctFirstByTitle(String title);
}
