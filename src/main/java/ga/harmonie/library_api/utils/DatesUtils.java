package ga.harmonie.library_api.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public final class DatesUtils {

    private DatesUtils() {
    }

    public static Date generateRandomDate() throws ParseException {
        var startDate = DateUtils.parseDate("01-01-1970", "dd-MM-yyyy");
        var endDate = DateUtils.parseDate("31-12-2023", "dd-MM-yyyy");
        var randomDate = getRandomDate(startDate, endDate);
        //System.out.println("Random Date using Commons: " + randomDate);
        return randomDate;
    }

    private static Date getRandomDate(Date startDate, Date endDate) {
        long randomEpochMillis = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime() + 1);
        return new Date(randomEpochMillis);
    }

}
