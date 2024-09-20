package ga.harmonie.library_api.mapper;

import ga.harmonie.library_api.dto.BookDTO;
import ga.harmonie.library_api.entities.Author;
import ga.harmonie.library_api.entities.Book;
import ga.harmonie.library_api.entities.BookType;
import ga.harmonie.library_api.entities.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source ="book.id",target = "bookId")
    @Mapping(source ="author.fullName",target = "authorFullname")
    //@Mapping(source ="bookType.title",target = "type")
    @Mapping(source ="book.title",target = "title")
    @Mapping(source ="book.isbn",target = "isbn")
    @Mapping(source ="book.price",target = "price")
    @Mapping(source ="book.language",target = "language")
    @Mapping(source ="book.publicationDate",target = "publicationDate")
    @Mapping(source ="book.pages",target = "pages")
    @Mapping(source ="publisher.publisherName",target = "publisherName")
    @Mapping(source ="publisher.creationDate",target = "publisherCreationDate")
    BookDTO toBookDTO(Book book, Author author, BookType bookType, Publisher publisher);
}
