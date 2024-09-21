package ga.harmonie.library_api.controller.Author;

import ga.harmonie.library_api.dto.AuthorDTO;
import ga.harmonie.library_api.entities.Author;
import ga.harmonie.library_api.mapper.AuthorMapper;
import ga.harmonie.library_api.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("library")
public class AuthorControllerImpl implements AuthorController{

    @Autowired
    AuthorServices authorServices;
    @Autowired
    AuthorMapper authorMapper;

    @Override
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        var authorList =  authorServices.showAllAuthors();
        var authorDTOList =  converAuthorsListToAuthorsDTOList(authorList);
        return new ResponseEntity<>(authorDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AuthorDTO> getAuthorByFullName(String fullName) {
        var optionalAuthor = authorServices.findAuthorByFullName(fullName);
        if(optionalAuthor.isPresent()){
            return new ResponseEntity<>(authorToAuthorDTO(optionalAuthor.get()),HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public AuthorDTO authorToAuthorDTO(Author author) {
        return authorMapper.INSTANCE.toAuthorDTO(author);
    }

    @Override
    public List<AuthorDTO> converAuthorsListToAuthorsDTOList(List<Author> authorsList) {
        var authorDTOList = new ArrayList<AuthorDTO>();
        authorsList.forEach(author -> authorDTOList.add(authorToAuthorDTO(author)));
        return authorDTOList;
    }

}
