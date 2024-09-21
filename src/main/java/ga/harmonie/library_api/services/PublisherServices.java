package ga.harmonie.library_api.services;

import ga.harmonie.library_api.entities.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherServices {

    Publisher addNewPublisher(Publisher newPublisher);
    List<Publisher> showAllPublishers();
    Optional<Publisher> getPublisherByName(String name);
}
