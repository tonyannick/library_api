package ga.harmonie.library_api.services.implementation;

import ga.harmonie.library_api.entities.Author;
import ga.harmonie.library_api.repositories.AuthorRepository;
import ga.harmonie.library_api.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Order(value = 1)
public class AuthorServicesImpl implements AuthorServices {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author addNewAuthor(Author newAuthor) {
        return authorRepository.save(newAuthor);
    }

    @Override
    public List<Author> showAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findAuthorByFullName(String fullName) {
        return authorRepository.findDistinctFirstByFullName(fullName);
    }
}
