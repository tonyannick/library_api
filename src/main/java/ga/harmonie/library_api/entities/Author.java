package ga.harmonie.library_api.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Collection;

@Data
@Entity(name = "tauthor")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 100, nullable = false)
    String fullName;

    @OneToMany(mappedBy = "author")
    Collection<Book> bookCollection;

    public Author(Builder builder){
        this.fullName = builder.fullName;
    }

    public static class Builder{

        String fullName;

        public Builder fullName(String fullName){
            this.fullName = fullName;
            return this;
        }

        public Author build(){
            return new Author(this);
        }
    }
}
