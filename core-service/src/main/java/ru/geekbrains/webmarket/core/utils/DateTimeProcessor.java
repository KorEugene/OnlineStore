package ru.geekbrains.webmarket.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeProcessor {

    private DateTimeProcessor() {
    }

    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
