package com.demo.common;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionCommonUtils {
    public static LocalDateTime milisecondToLocaleDate(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDateTime date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        return date;
    }
    public static String formatDate(LocalDateTime date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
