package ga.harmonie.library_api.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "tpublisher")
public class Publisher {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name",length = 150,nullable = false)
    String publisherName;

    @Column
    @Temporal(TemporalType.DATE)
    Date creationDate;

    @OneToMany(mappedBy = "publisher")
    Collection<Book> bookCollection;

    public Publisher(Builder builder){
        this.publisherName = builder.publisherName;
        this.creationDate = builder.creationDate;
    }

    public static class Builder{
        String publisherName;
        Date creationDate;

        public Builder publisherName(String publisherName){
            this.publisherName = publisherName;
            return this;
        }

        public Builder creationDate(Date creationDate){
            this.creationDate = creationDate;
            return this;
        }

        public Publisher build(){
            return new Publisher(this);
        }
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherName='" + publisherName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
