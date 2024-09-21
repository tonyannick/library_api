package ga.harmonie.library_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthorDTO {

    @JsonProperty("authorId")
    long authorId;
    @JsonProperty("authorFullName")
    String authorFullName;
}
