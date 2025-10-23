package ru.vasilkov.Service2.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;

@Slf4j
public class DateTimeUtil {
    public static SimpleDateFormat getCustomFormat() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }

    public static void timeDifference(String timeRequest, String timeNow) throws DateTimeParseException, ParseException {
        SimpleDateFormat formatter = getCustomFormat();

        Date date1 = formatter.parse(timeRequest);
        Date date2 = formatter.parse(timeNow);

        long differenceInMilliseconds = Math.abs(date2.getTime() - date1.getTime());

        log.info("time difference: {} ms", differenceInMilliseconds);
    }
}
