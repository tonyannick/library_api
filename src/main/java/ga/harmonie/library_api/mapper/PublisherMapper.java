package ga.harmonie.library_api.mapper;

import ga.harmonie.library_api.dto.PublisherDTO;
import ga.harmonie.library_api.entities.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    @Mapping(source ="publisher.id",target = "publisherId")
    @Mapping(source ="publisher.publisherName",target = "publisherFullName")
    @Mapping(source ="publisher.creationDate",target = "publisherCreationDate")
    PublisherDTO toPublisherDTO(Publisher publisher);
}
