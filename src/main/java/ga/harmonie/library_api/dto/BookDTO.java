package ga.harmonie.library_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDTO {

    @JsonProperty("bookId")
    long bookId;
    @JsonProperty("title")
    String title;
    @JsonProperty("isbn")
    String isbn;
    @JsonProperty("type")
    String type;
    @JsonProperty("pages")
    String pages;
    @JsonProperty("language")
    String language;
    @JsonProperty("authorFullname")
    String authorFullname;
    @JsonProperty("publicationDate")
    String publicationDate;
    @JsonProperty("price")
    Double price;
    @JsonProperty("publisherName")
    String publisherName;
    @JsonProperty("publisherCreationDate")
    String publisherCreationDate;
}
