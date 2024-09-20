package ga.harmonie.library_api.mapper;

import com.opencsv.bean.CsvBindByName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookCSVMapper {

    @CsvBindByName(column = "Title")
    String title;
    @CsvBindByName(column = "Author")
    String author;
    @CsvBindByName(column = "Master category")
    String mainType;
    @CsvBindByName(column = "Child category")
    String childType;
    @CsvBindByName(column = "Height")
    String height;
    @CsvBindByName(column = "Publisher")
    String publisher;
    @CsvBindByName(column = "Language")
    String language;

}
