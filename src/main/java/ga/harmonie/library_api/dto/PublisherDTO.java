package ga.harmonie.library_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PublisherDTO {

    @JsonProperty("publisherId")
    long publisherId;
    @JsonProperty("publisherFullName")
    String publisherFullName;
    @JsonProperty("publisherCreationDate")
    String publisherCreationDate;
}
