package ga.harmonie.library_api.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Entity(name = "tbook")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 150)
    String title;

    @Column
    Integer pages;

    @Column(nullable = false, unique = true)
    String isbn;

    @Column(nullable = false)
    Double price;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date publicationDate;

    @Column(nullable = false, length = 20)
    String language;

    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;

    @ManyToOne
    @JoinColumn(name = "type_id")
    BookType bookType;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    Publisher publisher;

    public Book(Builder builder){
        this.title = builder.title;
        this.pages = builder.pages;
        this.isbn = builder.isbn;
        this.price = builder.price;
        this.publicationDate = builder.publicationDate;
        this.language = builder.language;
    }

    public static class Builder{
        String title;
        Integer pages;
        String isbn;
        Double price;
        Date publicationDate;
        String language;

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder pages(Integer pages){
            this.pages = pages;
            return this;
        }

        public Builder isbn(String isbn){
            this.isbn = isbn;
            return this;
        }

        public Builder publicationDate(Date publicationDate){
            this.publicationDate = publicationDate;
            return this;
        }

        public Builder language(String language){
            this.language = language;
            return this;
        }

        public Builder price(Double price){
            this.price = price;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }



}
