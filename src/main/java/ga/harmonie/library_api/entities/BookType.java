package ga.harmonie.library_api.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Collection;

@Data
@Entity(name = "ttype")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class BookType {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 50, nullable = false)
    String title;

    @OneToMany(mappedBy = "bookType")
    Collection<Book> bookCollection;

    public BookType(Builder builder){
        this.title = builder.title;
    }

    public static class Builder{

        String title;

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public BookType build(){
            return new BookType(this);
        }
    }

}
