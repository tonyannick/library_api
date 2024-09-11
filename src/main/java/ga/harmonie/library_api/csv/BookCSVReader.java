package ga.harmonie.library_api.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ga.harmonie.library_api.mapper.BookCSVMapper;
import ga.harmonie.library_api.utils.ResourcesFilesUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class BookCSVReader {

    private static final String BOOK_CSV_FILE = "books.csv";

    public List<BookCSVMapper> loadBookDataFromCSVFile(){
        var csvFileInputStream = ResourcesFilesUtils.loadAppResourcesFiles(BOOK_CSV_FILE);
        try( var reader = ResourcesFilesUtils.readAppResourcesFiles(csvFileInputStream)) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(BookCSVMapper.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<BookCSVMapper> csvBookIterator = csvToBean.iterator();
            var bookCSVList = new ArrayList<BookCSVMapper>();
            csvBookIterator.forEachRemaining(bookCSVList::add);

            return bookCSVList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

}
