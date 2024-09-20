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
    String type;

    @OneToMany(mappedBy = "bookType")
    Collection<Book> bookCollection;

    public BookType(Builder builder){
        this.type = builder.type;
    }

    public static class Builder{

        String type;

        public Builder type(String type){
            this.type = type;
            return this;
        }

        public BookType build(){
            return new BookType(this);
        }
    }

    @Override
    public String toString() {
        return "BookType{" +
                "type='" + type + '\'' +
                '}';
    }
}
