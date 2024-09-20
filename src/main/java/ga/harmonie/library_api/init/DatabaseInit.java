package ga.harmonie.library_api.init;

import ga.harmonie.library_api.csv.BookCSVReader;
import ga.harmonie.library_api.entities.Author;
import ga.harmonie.library_api.entities.Book;
import ga.harmonie.library_api.entities.BookType;
import ga.harmonie.library_api.entities.Publisher;
import ga.harmonie.library_api.services.AuthorServices;
import ga.harmonie.library_api.services.BookServices;
import ga.harmonie.library_api.services.PublisherServices;
import ga.harmonie.library_api.utils.DatesUtils;
import ga.harmonie.library_api.utils.StringUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
@Order(value = 1)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DatabaseInit implements CommandLineRunner {

    @Autowired
    BookServices bookServices;
    @Autowired
    AuthorServices authorServices;
    @Autowired
    PublisherServices publisherServices;
    @Autowired
    BookCSVReader bookCSVReader;

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInit.class);

    @Override
    public void run(String... args) throws Exception {
        loadAllBooksFromCSVFile();
    }

    private void loadAllBooksFromCSVFile(){
        bookCSVReader.loadBookDataFromCSVFile().forEach(book -> {
            if(bookServices.findBookByTitle(book.getTitle()).isEmpty()){

                //Add author in database if he isn't exist
                var newAuthor = new Author.Builder()
                        .fullName(book.getAuthor())
                        .build();

                var optionalAuhtor = authorServices.findAuthorByFullName(book.getAuthor());
                if(optionalAuhtor.isEmpty()){
                    logger.info("Add author {} in database : ",newAuthor.getFullName());
                    authorServices.addNewAuthor(newAuthor);
                }

                //Add booktype in database if it isn't exist
                var newBookType = new BookType.Builder()
                        .type(book.getMainType())
                        .build();

                var optionalType = bookServices.findBookTypeByTitle(book.getMainType());
                if(optionalType.isEmpty()){
                    logger.info("Add type {} into database : ",newBookType);
                    bookServices.addBookType(newBookType);
                }

                try {
                    //Add publisher in database if it isn't exist
                    //generate random creation date for each publisher
                    var publisherCreationDate = DatesUtils.generateRandomDate();
                    var newPublisher = new Publisher.Builder()
                            .publisherName(book.getPublisher())
                            .creationDate(publisherCreationDate)
                            .build();

                    var optionalPublisher = publisherServices.findPublisherByName(book.getPublisher());
                    if(optionalPublisher.isEmpty()){
                        logger.info("Add publisher {} into database : ",newPublisher.getPublisherName());
                        publisherServices.addNewPublisher(newPublisher);
                    }

                    //generate random publication date for each book
                    var bookPublicationDate = DatesUtils.generateRandomDate();
                    //generate random book's isbn
                    var bookISBN = StringUtils.generateRandomWord(15);
                    //generate random book's price
                    var bookPrice = StringUtils.generateRandomValue();
                    var newBook = new Book.Builder()
                            .title(book.getTitle())
                            .pages(Integer.parseInt(book.getHeight()))
                            .language(book.getLanguage())
                            .isbn(bookISBN)
                            .price(Double.valueOf(bookPrice.replace(",",".")))
                            .publicationDate(bookPublicationDate)
                            .build();

                    //Add author if  exist
                    var checkAuthor = authorServices.findAuthorByFullName(book.getAuthor());
                    if(checkAuthor.isPresent()){
                        logger.info("Add author {} into database",checkAuthor.get());
                        newBook.setAuthor(checkAuthor.get());
                    }
                    //Add book type if exist
                    var checkBookType = bookServices.findBookTypeByTitle(book.getMainType());
                    if(checkBookType.isPresent()){
                        newBook.setBookType(checkBookType.get());
                    }
                    //Add publisher if exist
                    var checkPublisher = publisherServices.findPublisherByName(book.getPublisher());
                    if(checkPublisher.isPresent()){
                        newBook.setPublisher(checkPublisher.get());
                    }

                    //Add book if it does not exist
                    var optionalBook = bookServices.findBookByTitle(newBook.getTitle());
                    if(optionalBook.isEmpty()){
                        logger.info("Add book {} into database",newBook);
                        bookServices.addBook(newBook);
                    }

                } catch (ParseException e) {
                    logger.error("Error when trying to read the CSV file  \n : ", e);
                    throw new RuntimeException(e);
                }
            }
        });
    }


}
