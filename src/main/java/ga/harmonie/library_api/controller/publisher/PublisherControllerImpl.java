package ga.harmonie.library_api.controller.publisher;

import ga.harmonie.library_api.dto.PublisherDTO;
import ga.harmonie.library_api.entities.Publisher;
import ga.harmonie.library_api.mapper.PublisherMapper;
import ga.harmonie.library_api.services.PublisherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("library")
public class PublisherControllerImpl implements PublisherController{

    @Autowired
    PublisherServices publisherServices;
    @Autowired
    PublisherMapper publisherMapper;

    @Override
    public ResponseEntity<List<PublisherDTO>> getAllPublishers() {
        var publishersList = publisherServices.showAllPublishers();
        var publishersDTOList = convertPublishersListToPublishersDTOList(publishersList);
        return new ResponseEntity<>(publishersDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PublisherDTO> getPublisherByName(String name) {
        var optionalPublisher = publisherServices.getPublisherByName(name);
        if(optionalPublisher.isPresent()){
            return new ResponseEntity<>(publisherToPublisherDTO(optionalPublisher.get()),HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public List<PublisherDTO> convertPublishersListToPublishersDTOList(List<Publisher> publishersList) {
        var publishersDTOList = new ArrayList<PublisherDTO>();
        publishersList.forEach(publisher -> publishersDTOList.add(publisherToPublisherDTO(publisher)));
        return publishersDTOList;
    }

    @Override
    public PublisherDTO publisherToPublisherDTO(Publisher publisher) {
        return publisherMapper.toPublisherDTO(publisher);
    }
}
