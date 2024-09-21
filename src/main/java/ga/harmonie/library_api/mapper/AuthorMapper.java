package ga.harmonie.library_api.mapper;

import ga.harmonie.library_api.dto.AuthorDTO;
import ga.harmonie.library_api.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(source ="author.id",target = "authorId")
    @Mapping(source ="author.fullName",target = "authorFullName")
    AuthorDTO toAuthorDTO(Author author);
}
