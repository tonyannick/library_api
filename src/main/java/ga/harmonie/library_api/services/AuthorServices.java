package ga.harmonie.library_api.services;

import ga.harmonie.library_api.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorServices {

    Author addNewAuthor(Author newAuthor);
    List<Author> showAllAuthors();
    Optional<Author> findAuthorByFullName(String fullName);
}
