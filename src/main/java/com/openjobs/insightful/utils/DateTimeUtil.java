package com.openjobs.insightful.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

public final class DateTimeUtil {

    private DateTimeUtil() {
    }

    // Common patterns
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String ISO_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DISPLAY_DATE_TIME = "dd/MM/yyyy HH:mm:ss";

    private static final ZoneId SYSTEM_ZONE = ZoneId.systemDefault();

    // Current time
    public static LocalDateTime now() {
        return LocalDateTime.now(SYSTEM_ZONE);
    }

    public static LocalDate today() {
        return LocalDate.now(SYSTEM_ZONE);
    }

    // Conversions – null-safe
    public static Date toDate(LocalDateTime ldt) {
        Objects.requireNonNull(ldt, "LocalDateTime must not be null");
        return Date.from(ldt.atZone(SYSTEM_ZONE).toInstant());
    }

    public static Date toDate(LocalDate ld) {
        Objects.requireNonNull(ld, "LocalDate must not be null");
        return Date.from(ld.atStartOfDay(SYSTEM_ZONE).toInstant());
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        Objects.requireNonNull(date, "Date must not be null");
        return date.toInstant().atZone(SYSTEM_ZONE).toLocalDateTime();
    }

    public static LocalDate toLocalDate(Date date) {
        Objects.requireNonNull(date, "Date must not be null");
        return date.toInstant().atZone(SYSTEM_ZONE).toLocalDate();
    }

    // Formatting
    public static String format(LocalDateTime ldt, String pattern) {
        Objects.requireNonNull(ldt, "LocalDateTime must not be null");
        Objects.requireNonNull(pattern, "Pattern must not be null");
        return ldt.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String format(LocalDate ld, String pattern) {
        Objects.requireNonNull(ld, "LocalDate must not be null");
        Objects.requireNonNull(pattern, "Pattern must not be null");
        return ld.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseDateTime(String text, String pattern) {
        Objects.requireNonNull(text, "Text must not be null");
        Objects.requireNonNull(pattern, "Pattern must not be null");
        return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseDate(String text, String pattern) {
        Objects.requireNonNull(text, "Text must not be null");
        Objects.requireNonNull(pattern, "Pattern must not be null");
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(pattern));
    }

    // Start / End of day
    public static LocalDateTime startOfDay(LocalDate date) {
        Objects.requireNonNull(date, "Date must not be null");
        return date.atStartOfDay();
    }

    public static LocalDateTime endOfDay(LocalDate date) {
        Objects.requireNonNull(date, "Date must not be null");
        return date.atTime(LocalTime.MAX);
    }

    // Calculations
    public static long daysBetween(LocalDate start, LocalDate end) {
        Objects.requireNonNull(start, "Start date must not be null");
        Objects.requireNonNull(end, "End date must not be null");
        return ChronoUnit.DAYS.between(start, end);
    }

    public static int calculateAge(LocalDate birthDate) {
        Objects.requireNonNull(birthDate, "Birth date must not be null");
        return Period.between(birthDate, LocalDate.now(SYSTEM_ZONE)).getYears();
    }

    public static boolean isToday(LocalDate date) {
        Objects.requireNonNull(date, "Date must not be null");
        return date.isEqual(LocalDate.now(SYSTEM_ZONE));
    }
}