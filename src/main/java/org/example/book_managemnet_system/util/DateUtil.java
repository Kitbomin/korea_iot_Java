package org.example.book_managemnet_system.util;

import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final String PATTERN = ("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public static String now() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public static String format(LocalDateTime dateTime){
        return dateTime.format(FORMATTER);
    }

}
