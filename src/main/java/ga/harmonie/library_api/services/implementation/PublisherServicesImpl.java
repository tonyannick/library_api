package ga.harmonie.library_api.services.implementation;

import ga.harmonie.library_api.entities.Publisher;
import ga.harmonie.library_api.repositories.PublisherRepository;
import ga.harmonie.library_api.services.PublisherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Order(value = 1)
public class PublisherServicesImpl implements PublisherServices {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public Publisher addNewPublisher(Publisher newPublisher) {
        return publisherRepository.save(newPublisher);
    }

    @Override
    public List<Publisher> showAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> findPublisherByName(String name) {
        return publisherRepository.findDistinctFirstByPublisherName(name);
    }
}
