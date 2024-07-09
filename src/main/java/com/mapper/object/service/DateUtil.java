package com.mapper.object.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateUtil {

    private DateUtil() {

    }

    public static String getDate(String date, DateTimeFormatter formatter) {
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        return formatter.format(localDateTime);
    }

    public static String convertDate(String dateString, SimpleDateFormat fromDateFormat, SimpleDateFormat toDateFormat) {
        String convertedDateString = "";
        try {
            Date givenDate = fromDateFormat.parse(dateString);
            convertedDateString = toDateFormat.format(givenDate);
        } catch (ParseException e) {

        } catch (NullPointerException e) {

        }
        return convertedDateString;
    }

    public static Date parseDate(String dateString, String pattern) {
        // Create a SimpleDateFormat object with the desired pattern
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        // Use the parse method of the SimpleDateFormat object to convert the date string to a Date object
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
}
