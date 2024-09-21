package ga.harmonie.library_api.controller.publisher;


import ga.harmonie.library_api.dto.PublisherDTO;
import ga.harmonie.library_api.entities.Publisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PublisherController {

    @GetMapping("/publishers")
    ResponseEntity<List<PublisherDTO>> getAllPublishers();

    @GetMapping("/publisher/{name}")
    ResponseEntity<PublisherDTO> getPublisherByName(@PathVariable("name") String name);

    List<PublisherDTO> convertPublishersListToPublishersDTOList(List<Publisher> publishersList);
    PublisherDTO publisherToPublisherDTO(Publisher publisher);

}
