package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateUtility {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");


    public static Date formatActualDate(String actualUpdatedAtString) throws ParseException {
        return formatter.parse(actualUpdatedAtString);
    }

    public static LocalDate formatToLocalDate(String actualUpdatedAtString) throws ParseException {
        Date actualDate = formatActualDate(actualUpdatedAtString);

        return actualDate.toInstant()
                .atZone(ZoneId.of("Europe/London"))
                .toLocalDate();
    }

    public static LocalDate tbilisiLocalDate(){
        ZonedDateTime tbilisiTime = ZonedDateTime.now(ZoneId.of("Asia/Tbilisi"));
        ZonedDateTime londonTime = tbilisiTime.withZoneSameInstant(ZoneId.of("Europe/London"));

        return londonTime.toLocalDate();
    }

}

