package ga.harmonie.library_api.repositories;

import ga.harmonie.library_api.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findDistinctFirstByFullName(String fullName);

}
