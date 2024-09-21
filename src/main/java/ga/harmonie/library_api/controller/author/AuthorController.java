package ga.harmonie.library_api.controller.author;

import ga.harmonie.library_api.dto.AuthorDTO;
import ga.harmonie.library_api.entities.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AuthorController {

    @GetMapping("/authors")
    ResponseEntity<List<AuthorDTO>> getAllAuthors();

    @GetMapping("/author/fullname/{fullName}")
    ResponseEntity<AuthorDTO> getAuthorByFullName(@PathVariable("fullName") String fullName);

    List<AuthorDTO> convertAuthorsListToAuthorsDTOList(List<Author> authorsList);
    AuthorDTO authorToAuthorDTO(Author author);
}
